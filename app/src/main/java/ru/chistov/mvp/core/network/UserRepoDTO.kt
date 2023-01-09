package ru.chistov.mvp.core.network

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserRepoDTO (
    @Expose
    @SerializedName("name")
    val repo: String,
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("forks")
    val forks: Int
        ): Parcelable