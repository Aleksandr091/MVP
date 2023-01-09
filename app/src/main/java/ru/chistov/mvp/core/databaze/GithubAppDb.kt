package ru.chistov.mvp.core.databaze

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserDBObject::class, RepoDBObject::class],
    version = 1
)
abstract class GithubAppDb : RoomDatabase() {

    abstract fun userDao():UserDAO

    companion object{
        fun create(context: Context): GithubAppDb {
            return Room.databaseBuilder(context,
                GithubAppDb::class.java,
                "github.db")
                .build()
        }
    }


}