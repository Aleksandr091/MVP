package ru.chistov.mvp.repository.Interface

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.model.GithubUserRepo

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserById(login: String): Single<GithubUser>
    fun getReposByUsers(login: String): Single<List<GithubUserRepo>>
}