package ru.marina_w.my_map

import ru.marina_w.my_map.room.UserInfoEntity

class UserModelMapper {
    fun mapUserModel(entity: UserInfoEntity): UserModel{
        return UserModel(userName = entity.userName,
            numberPhone = entity.numberPhone,
            userImageUrl = entity.uriImageAvatar,
            userPublicStatus = entity.statusSound,
            userGeoPosition = entity.likeMapPlace)
    }
}