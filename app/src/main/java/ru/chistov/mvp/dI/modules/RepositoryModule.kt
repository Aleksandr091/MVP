package ru.chistov.mvp.dI.modules

import dagger.Module
import dagger.Provides
import ru.chistov.mvp.ConnectivityListener
import ru.chistov.mvp.core.databaze.RoomGithubUsersCache
import ru.chistov.mvp.core.databaze.UserDAO
import ru.chistov.mvp.core.network.UsersApi
import ru.chistov.mvp.repository.Interface.GithubRepository
import ru.chistov.mvp.repository.impl.GithubRepositoryImpl
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        usersApi: UsersApi,
        userDao: UserDAO,
        networkStatus: ConnectivityListener
    ): GithubRepository {
        return GithubRepositoryImpl(usersApi, userDao, networkStatus)
    }
}