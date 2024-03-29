package ru.marina_w.my_map.auth

import ru.marina_w.my_map.UserModel
import ru.marina_w.my_map.UserModelMapper
import ru.marina_w.my_map.room.UserInfoEntity

class UserProfileUseCase {
    private val repository = UserRepository.getInstance()
    private val mapper= UserModelMapper()
    //База данных

    suspend fun addUser(entity: UserInfoEntity){
        repository.addUserId(entity)
    }
    suspend fun deleteUser(){
        repository.deleteUser()
    }
    suspend fun getUser(): UserModel{
        return mapper.mapUserModel(repository.getUser())
    }



}