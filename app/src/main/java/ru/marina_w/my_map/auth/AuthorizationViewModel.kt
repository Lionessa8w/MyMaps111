package ru.marina_w.my_map.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

//Ввод смс
class AuthorizationViewModel : ViewModel() {

    private var smsCode: String? = null
    private val useCase = UserUseCase.getInstance()
    private var _sharedSmsViewModel = MutableSharedFlow<ActionSMS>()
    val sharedSmsViewModel = _sharedSmsViewModel.asSharedFlow()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
        viewModelScope.launch {
            _sharedSmsViewModel.emit(
                ActionSMS.ErrorSMS(throwable.localizedMessage ?: throwable.message ?: "")
            )
        }
    }
    init {
        getSmsCode()
    }
    fun getSmsCode(): String{
        return smsCode ?: ""
    }
    fun setCurrentSms( code: String){
        smsCode=code
    }


}