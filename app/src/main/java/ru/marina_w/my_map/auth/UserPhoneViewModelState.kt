package ru.marina_w.my_map.auth

import ru.marina_w.my_map.UserModel

sealed class UserPhoneViewModelState {
    object Loading :UserPhoneViewModelState()
    data class Error(val message: String) : UserPhoneViewModelState()

    class Success : UserPhoneViewModelState()
}