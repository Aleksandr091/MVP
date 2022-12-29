package ru.chistov.mvp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserRepo(
    val repo: String,
    val forks: Int
) : Parcelable