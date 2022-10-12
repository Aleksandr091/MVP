package ru.chistov.mvp.repository.Interface

import ru.chistov.mvp.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
    fun getUserById(id: Long): GithubUser?
}