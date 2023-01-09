package ru.chistov.mvp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import ru.chistov.mvp.core.databaze.GithubAppDb

class GeekBrainsApp : Application() {


    companion object {
        lateinit var instance: GeekBrainsApp
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router
    private lateinit var connectivityListener: ConnectivityListener

    val database by lazy {
        GithubAppDb.create(this) }

    override fun onCreate() {
        super.onCreate()
        instance = this

        connectivityListener = ConnectivityListener(
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        )

            RxJavaPlugins.setErrorHandler {
                if (it is UndeliverableException) {
                    Log.e("1", it.message.toString())
                }
            }

    }
    fun getConnectObservable() = connectivityListener.status()
    fun getConnectSingle() = connectivityListener.statusSingle()
}