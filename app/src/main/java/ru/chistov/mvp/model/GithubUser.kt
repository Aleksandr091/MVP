package ru.chistov.mvp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val login: String,
    val id: Long,
    val avatarUrl: String?,
    var repos: List<GithubUserRepo>? = null
) : Parcelable