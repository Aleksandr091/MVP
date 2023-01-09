package ru.chistov.mvp.core.databaze

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.core.mapper.UserMapper
import ru.chistov.mvp.core.network.UserDTO

class RoomGithubUsersCache(private val userDAO: UserDAO):IDependency {

    override fun usersCache(predicate: Boolean,
                            list:Single<List<UserDTO>>
    ): Single<List<UserDTO>>{
        return if (predicate) {
            list.flatMap {
                userDAO.insertALL(it.map(UserMapper::mapToDBObject)).andThen(Single.just(it))
            }
        } else {
            list
        }
    }

}
