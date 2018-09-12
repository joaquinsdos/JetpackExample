package es.sdos.joaquinruiz.livedataexample.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idUser")            var id: Int = 0,
        @ColumnInfo(name = "username")          var username: String = "")

