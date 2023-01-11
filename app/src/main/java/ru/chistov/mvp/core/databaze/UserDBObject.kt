package ru.chistov.mvp.core.databaze

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDBObject (
    @PrimaryKey
    @ColumnInfo(name = PRIMARY_KEY)
    val login:String,
    val id:Long,
    val avatarUrl: String?
    ){
    companion object{
        const val PRIMARY_KEY = "login"
    }
}