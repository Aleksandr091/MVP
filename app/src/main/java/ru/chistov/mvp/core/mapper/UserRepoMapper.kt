package ru.chistov.mvp.core.mapper

import ru.chistov.mvp.core.network.UserDTO
import ru.chistov.mvp.core.network.UserRepoDTO
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.model.GithubUserRepo

object UserRepoMapper {
    fun mapToEntity(dto: UserRepoDTO):GithubUserRepo{
        return GithubUserRepo(
            repo = dto.repo
        )
    }

}