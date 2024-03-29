package ru.marina_w.my_map.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
@Dao
interface UserDao {

    @Query("SELECT  * FROM user_info_entity")
    fun getUser(): UserInfoEntity
// удаление одного юзера из одного
    //убрать йди
    @Query("DELETE FROM user_info_entity WHERE id = :id")
    fun deletedIdUser(id: String)
    //удаление всей таблицы
    @Query("DROP TABLE user_info_entity")
    fun deleteUserTable()

    @Insert(entity = UserInfoEntity::class)
    fun addNewUser(entity: UserInfoEntity)



}

@Database(
    version = 1,
    entities = [UserInfoEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userListDao(): UserDao
}