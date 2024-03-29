package ru.marina_w.my_map.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info_entity")
data class UserInfoEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "number_phone") val numberPhone: String,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "uri_image_avatar") val uriImageAvatar: String,
    @ColumnInfo(name = "status_sound") val statusSound: String,
    @ColumnInfo(name = "like_map_place") val likeMapPlace: Map<String?, String?>
)
