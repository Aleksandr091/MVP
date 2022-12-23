package ru.chistov.mvp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.core.mapper.UserMapper
import ru.chistov.mvp.core.mapper.UserRepoMapper
import ru.chistov.mvp.core.network.UsersApi
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.repository.Interface.GithubRepository

class GithubRepositoryImpl(
    private val usersApi: UsersApi
):GithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers().map{it.map (UserMapper::mapToEntity)}
    }

    override fun getUserById(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }

    override fun getReposByUsers(login: String): Single<List<GithubUserRepo>> {
        return usersApi.getRepos(login).map { it.map (UserRepoMapper::mapToEntity) }
    }
}