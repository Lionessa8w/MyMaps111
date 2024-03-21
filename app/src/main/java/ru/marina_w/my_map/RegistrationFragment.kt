package ru.marina_w.my_map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import java.util.concurrent.TimeUnit

class RegistrationFragment : Fragment() {
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private var storedVerificationId: String? = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_registration, container, false)
        val numberPhone: EditText = view.findViewById(R.id.phone_number)
        val buttonSMS: Button = view.findViewById(R.id.button_sms)

        buttonSMS.setOnClickListener {
            if (numberPhone.text.isNotBlank()|| numberPhone.text.length<10) {
                buttonSMS.isEnabled=false
                Toast.makeText(activity, "Введите номер телефона", Toast.LENGTH_SHORT).show()
            }else{
                buttonSMS.isEnabled=true
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firebaseAuth = Firebase.auth
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber("+79963813976") // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity()) // Activity (for callback binding)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    Log.d("checkResult", "onVerificationCompleted: $credential")
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
        PhoneAuthProvider.verifyPhoneNumber(options)



//
//        val numberPhone: EditText = view.findViewById(R.id.phone_number)
//        val buttonSMS: Button = view.findViewById(R.id.button_sms)
//
//        buttonSMS.setOnClickListener {
//            if (numberPhone.text.isNotBlank()) {
//
//            }
//        }
    }
}