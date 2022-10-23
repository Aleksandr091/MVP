package ru.chistov.mvp.core.mapper

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

}