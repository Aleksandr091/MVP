package ru.chistov.mvp.core.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserRepoDTO (
    @Expose
    @SerializedName("name")
    val repo: String
        )