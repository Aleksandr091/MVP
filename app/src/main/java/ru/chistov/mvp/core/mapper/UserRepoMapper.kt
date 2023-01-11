package ru.chistov.mvp.core.mapper

import ru.chistov.mvp.core.databaze.RepoDBObject
import ru.chistov.mvp.core.databaze.UserDBObject
import ru.chistov.mvp.core.network.UserDTO
import ru.chistov.mvp.core.network.UserRepoDTO
import ru.chistov.mvp.model.GithubUserRepo

object UserRepoMapper {
    fun mapToEntity(dto: UserRepoDTO): GithubUserRepo {
        return GithubUserRepo(
            id = dto.id,
            repo = dto.repo,
            forks = dto.forks
        )
    }
    fun mapToEntity(repoDBObject: RepoDBObject): GithubUserRepo {
        return GithubUserRepo(
            id = repoDBObject.id,
            repo = repoDBObject.repo,
            forks = repoDBObject.forks
        )
    }


}