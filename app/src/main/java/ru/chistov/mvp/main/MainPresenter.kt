package ru.chistov.mvp.main

import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.UsersScreen

@InjectViewState
class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}