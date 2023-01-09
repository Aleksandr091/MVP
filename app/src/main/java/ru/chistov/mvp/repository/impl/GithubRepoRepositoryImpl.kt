package ru.chistov.mvp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.core.mapper.UserRepoMapper
import ru.chistov.mvp.core.network.UsersApi
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.repository.Interface.GithubRepoRepository

class GithubRepoRepositoryImpl constructor(
    private val usersApi: UsersApi,
) : GithubRepoRepository {

    override fun getReposByUsers(login: String): Single<List<GithubUserRepo>> {
        return usersApi.getRepos(login).map { it.map(UserRepoMapper::mapToEntity) }
    }
}