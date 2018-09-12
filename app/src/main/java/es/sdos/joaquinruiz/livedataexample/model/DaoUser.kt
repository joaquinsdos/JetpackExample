package es.sdos.joaquinruiz.livedataexample.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface DaoUser {
    @Query("select * from users")
    fun getAllUser(): LiveData<List<User>>

    @Query("select * from users where idUser in (:id)")
    fun getUserById(id: Int): LiveData<User>

    @Query("delete from users")
    fun deleteAllUser()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(contact: User)

    @Update
    fun updateUser(contact: User)

    @Delete
    fun deleteUser(contact: User)
}