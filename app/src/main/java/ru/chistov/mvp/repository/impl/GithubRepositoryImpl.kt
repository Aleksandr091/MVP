package ru.chistov.mvp.repository.impl

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.chistov.mvp.INetworkStatus
import ru.chistov.mvp.core.databaze.*
import ru.chistov.mvp.core.mapper.UserMapper
import ru.chistov.mvp.core.mapper.UserRepoMapper
import ru.chistov.mvp.core.network.UsersApi
import ru.chistov.mvp.doCompletableIf
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.repository.Interface.GithubRepository

class GithubRepositoryImpl constructor(
    private val usersApi: UsersApi,
    private val userDAO: UserDAO,
    private val networkStatus: INetworkStatus,
) : GithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers().map { it.map(UserMapper::mapToEntity) }

    }

    private fun fetchFromApi(shouldPersist: Boolean): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .doCompletableIf(shouldPersist) {
                userDAO.insertALL(it.map(UserMapper::mapToDBObject))
            }.map { it.map(UserMapper::mapToEntity) }
    }
    private fun getFromDb(): Single<List<GithubUser>> {
        return userDAO.queryForALLUsers().map { it.map(UserMapper::mapToEntity) }
    }

    override fun getUserWithRepos(login: String): Single<GithubUser> {
        return userDAO.getUserWithRepos(login)
            .map { userWithRepos ->
                val user = UserMapper.mapToEntity(userWithRepos.userDBObject)
                user.repos = userWithRepos.repos.map { UserRepoMapper.mapToEntity(it) }
                user
            }
    }


    private fun fetchUserFromApi(shouldPersist: Boolean, login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .doCompletableIf(shouldPersist) {
                userDAO.insert(UserMapper.mapToDBObject(it))
            }.map(UserMapper::mapToEntity)
    }

    override fun getUserById(login: String): Single<GithubUser> {
        return usersApi.getUser(login).map(UserMapper::mapToEntity)


    }


    private fun getUserFromDb(login: String): Single<GithubUser> {
        return userDAO.queryForUsers(login).map(UserMapper::mapToEntity)
    }



    override fun getReposByUsers(login: String): Single<List<GithubUserRepo>> {
        return usersApi.getRepos(login).map { it.map(UserRepoMapper::mapToEntity) }

    }

    private fun getReposFromDb(login: String): Single<List<GithubUserRepo>> {
        return userDAO.queryForReposUser(login).map { it.map(UserRepoMapper::mapToEntity) }
    }

    private fun fetchFromApiRepos(shouldPersist: Boolean,login: String): Single<List<GithubUserRepo>> {
        return usersApi.getRepos(login)
            .doCompletableIf(shouldPersist) {repositories ->
                userDAO.insertRepo(repositories.map {
                    RepoDBObject(
                        (it.id ?: "") as Long, it.repo ?: "", it.forks ?: 0,
                        login) }
                )
            }.map { it.map(UserRepoMapper::mapToEntity) }
    }




}


