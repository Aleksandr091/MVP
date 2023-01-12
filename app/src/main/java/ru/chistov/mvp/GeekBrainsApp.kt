package ru.chistov.mvp

import android.app.Application
import ru.chistov.mvp.core.databaze.GithubAppDb
import ru.chistov.mvp.dI.AppComponent
import ru.chistov.mvp.dI.DaggerAppComponent
import ru.chistov.mvp.dI.modules.AppModule

class GeekBrainsApp : Application() {



    companion object {
        lateinit var instance: GeekBrainsApp
    }


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this


        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }



}