package ru.chistov.mvp.core.databaze

import io.reactivex.rxjava3.core.Single
import ru.chistov.mvp.core.network.UserDTO

interface IDependency {
    fun usersCache(predicate: Boolean,
                   list: Single<List<UserDTO>>
    ): Single<List<UserDTO>>
}