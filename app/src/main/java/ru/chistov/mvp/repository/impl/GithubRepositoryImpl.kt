package ru.chistov.mvp.repository.impl

import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.repository.Interface.GithubRepository

class GithubRepositoryImpl : GithubRepository {
    private val repositories = listOf(
        GithubUser("Dmitriy",1),
        GithubUser("Sergey",2),
        GithubUser("Oleg",3),
        GithubUser("Victor",4)
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }

    override fun getUserById(id:Long ): GithubUser? {
        return repositories.find { it.id==id }
    }
}