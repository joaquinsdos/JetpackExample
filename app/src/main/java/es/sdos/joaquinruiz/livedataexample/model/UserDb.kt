package es.sdos.joaquinruiz.livedataexample.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = [(User::class)], version = 3, exportSchema = false)
abstract class UserDb : RoomDatabase() {
    companion object {
        private var INSTANCE: UserDb? = null
        fun getDataBase(context: Context): UserDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, UserDb::class.java, "User-db")
                        .allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE as UserDb
        }
    }

    abstract fun daoUser(): DaoUser
}