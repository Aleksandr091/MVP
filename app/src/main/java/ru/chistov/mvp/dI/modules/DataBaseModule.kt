package ru.chistov.mvp.dI.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.chistov.mvp.core.databaze.GithubAppDb
import ru.chistov.mvp.core.databaze.UserDAO
import javax.inject.Singleton

@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun database(context: Context): GithubAppDb =
        GithubAppDb.create(context)

    @Singleton
    @Provides
    fun userDao(database: GithubAppDb): UserDAO =
        database.userDao()
}