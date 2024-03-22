package ru.marina_w.my_map.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import java.util.concurrent.TimeUnit

// Ввод номера телефона
private const val TAG= "RegistrationViewModel"
class RegistrationViewModel:ViewModel() {

    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private var storedVerificationId: String? = ""
    private val firebaseAuth = Firebase.auth

    private val _listUserState =
        MutableLiveData<UserPhoneListViewModelState>(UserPhoneListViewModelState.Loading)
    val listUserState: LiveData<UserPhoneListViewModelState> = _listUserState

    fun sentSmsCode(){
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber("+79963813976") // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    Log.d("checkResult", "onVerificationCompleted: $credential")
                    signInWithPhoneAuthCredential(credential)
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Log.d("checkResult", "onVerificationFailed: $e")
                }

                override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(verificationId, token)
                    Log.d("checkResult", "onCodeSent:$verificationId")
                    storedVerificationId = verificationId
                    resendToken = token
                }

            }) // OnVerificationStateChangedCallbacks
            .build()
        //проверкa номера телефона пользователя
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
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




}