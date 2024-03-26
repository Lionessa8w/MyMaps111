package ru.marina_w.my_map.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

// Ввод номера телефона
private const val TAG = "RegistrationViewModel"

class RegistrationPhoneViewModel : ViewModel() {

    private val useCase = UserUseCase.getInstance()
    private val _sharedNumberPhoneViewModel = MutableSharedFlow<ActionNumberPhone>()
    val sharedNumberPhoneViewModel = _sharedNumberPhoneViewModel.asSharedFlow()

    private var currentPhoneNumber: String? = null

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            viewModelScope.launch { _sharedNumberPhoneViewModel.emit(
                ActionNumberPhone.ErrorNumberPhone(
                    throwable.localizedMessage ?: throwable.message ?: ""
                )
            ) }


        }


    init {
        getUserNumberPhone()
    }

    fun getUserNumberPhone(): String {
        return currentPhoneNumber?:""


    }

    fun setCurrentNumber(number:String){
        currentPhoneNumber=number

    }

}