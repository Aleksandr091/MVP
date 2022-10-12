package ru.chistov.mvp.repository.Interface

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.model.GithubUser

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserById(id: Long): Single<GithubUser>
}