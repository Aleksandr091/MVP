package ru.chistov.mvp.core.mapper

import ru.chistov.mvp.core.databaze.UserDBObject
import ru.chistov.mvp.core.network.UserDTO
import ru.chistov.mvp.model.GithubUser

object UserMapper {
    fun mapToEntity(dto:UserDTO):GithubUser{
        return GithubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }
    fun mapToEntity(dbObject: UserDBObject):GithubUser{
        return GithubUser(
            id = dbObject.id,
            login = dbObject.login,
            avatarUrl = dbObject.avatarUrl
        )
    }
    fun mapToDBObject(dto:UserDTO):UserDBObject{
        return UserDBObject(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }

}