package ru.marina_w.my_map.auth

class UserUseCase private constructor() {

    private val repository = UserRepository.getInstance()
    private var smsCallback: SmsCallback? = null
    private var numberPhoneCallback: NumberPhoneCallback? = null

    private fun isCodeSent(): Boolean{
        return AuthSmsResponseState.Success
    }
    private fun fallNumberPhone(): AuthNumberPhoneResponseState.Error{
        return AuthNumberPhoneResponseState.Error("")
    }

    private fun installCallbackNumberPhone(callbackPhone: NumberPhoneCallback) {
         numberPhoneCallback = callbackPhone
    }

    private fun deleteCallbackNumberPhone() {
         numberPhoneCallback = null

    }

    private fun installCallbackSms(callbackSMS: SmsCallback) {
        smsCallback = callbackSMS
    }

    private fun deleteCallbackSms() {
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