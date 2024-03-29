package ru.marina_w.my_map

import java.sql.ClientInfoStatus
import java.text.FieldPosition

data class UserModel(
    val userName: String? =null,
    val numberPhone: String? =null,
    val userImageUrl: String?=null,
    val userGeoPosition: Map<String,String?>,
    val userPublicStatus: String?= null

)