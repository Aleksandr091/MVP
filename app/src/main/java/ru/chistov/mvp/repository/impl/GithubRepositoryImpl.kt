package ru.chistov.mvp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.repository.Interface.GithubRepository
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class GithubRepositoryImpl : GithubRepository {
    private val repositories = listOf(
        GithubUser("Dmitriy",1),
        GithubUser("Sergey",2),
        GithubUser("Oleg",3),
        GithubUser("Victor",4)
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }.delay(3,TimeUnit.SECONDS)
    }

    override fun getUserById(id:Long ): Single<GithubUser> {
        return Single.create {
            repositories.find { it.id==id }?.let { it1 -> it.onSuccess(it1) }
        }
    }
}