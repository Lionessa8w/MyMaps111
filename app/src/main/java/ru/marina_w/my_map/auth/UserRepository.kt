package ru.marina_w.my_map.auth

import android.app.Activity
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import java.util.concurrent.TimeUnit
import ru.marina_w.my_map.AuthorizationFragment

private const val TAG= "UserRepository"
class UserRepository private constructor() {
    private var activity: Activity? = null
    private val firebaseAuth = Firebase.auth
    private var storedVerificationId: String? = ""


    fun bind(activity: Activity) {
        this.activity = activity
    }

    fun realise() {
        activity = null
    }
    fun sentFonNumber(phone:String, callback: NumberPhoneCallback){
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                // номер телефона пользователя успешно проверен
                override fun onVerificationCompleted(credential: PhoneAuthCredential) = Unit

                //Этот метод вызывается в ответ на недействительный запрос проверки,
                //например запрос, в котором указан неверный номер телефона или код проверки.

                override fun onVerificationFailed(e: FirebaseException) {
                    callback.setAuthNumberPhoneResponseState(AuthNumberPhoneResponseState.Error(
                        e.message ?: ""
                    ))
                    Log.d("checkResult", "onVerificationFailed: $e")
                }
                //Этот метод вызывается после отправки кода подтверждения по SMS на указанный номер телефона.
                //
                //При вызове этого метода большинство приложений отображают
                // пользовательский интерфейс,
                // предлагающий пользователю ввести код подтверждения из SMS-сообщения.
                // (В то же время автоматическая проверка может выполняться в фоновом режиме.)

                override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(verificationId, token)
                    callback.setAuthNumberPhoneResponseState(AuthNumberPhoneResponseState.Success())
                    Log.d("checkResult", "onCodeSent:$verificationId")
                    storedVerificationId=verificationId


                }

            }) // OnVerificationStateChangedCallbacks
            .build()
        //проверкa номера телефона пользователя
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
    //войти в систему с учетными данными для аутентификации телефона
    private fun sentSmsCode(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(activity!!) { task ->
                if (task.isSuccessful) {



                    // переход из фрагмента в другой фрагмент
                    val fragment=AuthorizationFragment()
                    val transaction=
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = task.result?.user
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }
    //подтвердить номер телефона с помощью кода
    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        // [START verify_with_code]
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        // [END verify_with_code]
    }

    companion object {
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            return synchronized(this) {
                val currentInstance = INSTANCE ?: UserRepository()
                INSTANCE = currentInstance
                currentInstance
            }
        }
    }
}