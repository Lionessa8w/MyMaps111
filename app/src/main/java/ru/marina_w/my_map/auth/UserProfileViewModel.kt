package ru.marina_w.my_map.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firebase.ui.auth.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.marina_w.my_map.UserModel
import ru.marina_w.my_map.room.UserInfoEntity
import ru.marina_w.my_map.user_profile_view_model_state.UserProfileState

class UserProfileViewModel : ViewModel(){

    private val _flowUserState= MutableStateFlow<UserProfileState>(UserProfileState.Loading())
    val flowUserState=_flowUserState.asStateFlow()


    private val useCase= UserProfileUseCase()

    fun fetchProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            _flowUserState.emit(UserProfileState.Success(useCase.getUser()))
        }
    }





}