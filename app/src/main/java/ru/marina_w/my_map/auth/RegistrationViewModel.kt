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



    private val _listUserState =
        MutableLiveData<UserPhoneViewModelState>(UserPhoneViewModelState.Loading)
    val listUserState: LiveData<UserPhoneViewModelState> = _listUserState


}