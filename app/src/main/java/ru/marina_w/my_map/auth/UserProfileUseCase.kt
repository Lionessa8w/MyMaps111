package ru.marina_w.my_map.auth

class UserProfileUseCase {
    private val repository = UserRepository.getInstance()
    //База данных
    suspend fun getAllUser(){
        repository.getAllUser()
    }
    suspend fun getNumberPhoneUser(id: String){
        repository.getNumberPhoneUser(id)
    }
    suspend fun addUser(id: String){
        repository.addUserId(id)
    }
    suspend fun deleteUser(id: String){
        repository.deleteUserId(id)
    }


}