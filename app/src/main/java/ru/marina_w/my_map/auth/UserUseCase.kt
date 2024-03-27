package ru.marina_w.my_map.auth

import com.google.android.play.integrity.internal.c

class UserUseCase private constructor() {

    private val repository = UserRepository.getInstance()
    private var smsCallback: SmsCallback? = null
    private var numberPhoneCallback: NumberPhoneCallback? = null

    fun sendCode(code: String) {
        return repository.sentSmsCode(code, smsCallback)
    }

    fun fallNumberPhone(): AuthNumberPhoneResponseState.Error {
        return AuthNumberPhoneResponseState.Error("")
    }

    fun addNumberPhoneCallback(callback: NumberPhoneCallback){
        numberPhoneCallback=callback
    }

    fun installCallbackNumberPhone(callbackPhone: String) {
        val callback = numberPhoneCallback ?: return
        return repository.sendFonNumber(callbackPhone, callback)
    }

    fun deleteCallbackNumberPhone() {
        numberPhoneCallback = null

    }

    fun installCallbackSms(callbackSMS: SmsCallback) {
        smsCallback = callbackSMS
    }

    fun deleteCallbackSms() {
        smsCallback = null
    }


    companion object {
        private var INSTANCE: UserUseCase? = null

        fun getInstance(): UserUseCase {
            return synchronized(this) {
                val currentInstance = INSTANCE ?: UserUseCase()
                INSTANCE = currentInstance
                currentInstance
            }
        }
    }
}