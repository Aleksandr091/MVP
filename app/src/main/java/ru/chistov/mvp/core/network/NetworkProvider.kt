package ru.chistov.mvp.core.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.chistov.mvp.BuildConfig

object NetworkProvider {

    val usersApi by lazy { createRetrofit().create(UsersApi::class.java) }

    private fun createGson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) //вместо @SerializedName
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    fun createRetrofit() = Retrofit.Builder().apply {
        addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        addConverterFactory(GsonConverterFactory.create(createGson()))
        baseUrl(BuildConfig.SERVER_URL)
    }.build()
}