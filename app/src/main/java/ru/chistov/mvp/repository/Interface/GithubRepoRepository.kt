package ru.chistov.mvp.repository.Interface

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.core.databaze.UserWithReposDBObject
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.model.GithubUserRepo

interface GithubRepoRepository {
    fun getReposByUsers(login: String): Single<List<GithubUserRepo>>
}