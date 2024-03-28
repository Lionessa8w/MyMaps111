package ru.marina_w.my_map.auth

import androidx.lifecycle.ViewModel

class UserProfileViewModel : ViewModel(){

    private val useCase= UserProfileUseCase()

    suspend fun getNumberPhoneUser(id: String){
        useCase.getNumberPhoneUser(id)

    }
    fun getNameUser(id: String){


    }
    fun getStatusSound(id: String){

    }
    fun getImageUser(id: String){

    }
    fun getLikeMapPlace(id: String){

    }



}