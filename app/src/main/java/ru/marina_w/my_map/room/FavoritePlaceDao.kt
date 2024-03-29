package ru.marina_w.my_map.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
@Dao
interface FavoritePlaceDao {
    @Query("SELECT  * FROM favorite_places")
    fun getAllPlace(): List<FavoritePlace>
    // удаление одного юзера из одного
    //убрать йди
    @Query("DELETE FROM favorite_places WHERE placeId = :id")
    fun deletedPlace(id: String)

    @Insert(entity = UserInfoEntity::class)
    fun addNewUser(entity: FavoritePlace)



}

@Database(
    version = 1,
    entities = [FavoritePlace::class]
)
abstract class AppMapDatabase : RoomDatabase() {
    abstract fun placesListDao(): FavoritePlaceDao
}
