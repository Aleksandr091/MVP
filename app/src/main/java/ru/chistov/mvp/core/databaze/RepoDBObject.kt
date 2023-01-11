package ru.chistov.mvp.core.databaze

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class RepoDBObject(
    @PrimaryKey
    @ColumnInfo(name = PRIMARY_KEY)
    val id: Long,
    val repo: String,
    val forks: Int,
    @ColumnInfo(name = FOREIGN_USER_KEY)
    val userId:String
){
    companion object{
        const val PRIMARY_KEY = "id"
        const val FOREIGN_USER_KEY = "userId"
    }
}