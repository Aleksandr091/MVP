package ru.chistov.mvp.core.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDTO (
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String
        )