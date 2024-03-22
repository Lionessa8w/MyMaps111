package ru.marina_w.my_map.auth

import ru.marina_w.my_map.UserModel

sealed class UserPhoneListViewModelState {
    object Loading :UserPhoneListViewModelState()
    data class Error(val message: String) : UserPhoneListViewModelState()

    class Success(
        val userList: List<UserModel>
    ) : UserPhoneListViewModelState()
}