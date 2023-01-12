package ru.chistov.mvp.main

import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.UsersScreen
import javax.inject.Inject

@InjectViewState
class MainPresenter() : MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}