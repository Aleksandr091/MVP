package ru.chistov.mvp.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.DetailsScreen
import ru.chistov.mvp.repository.Interface.GithubRepository

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onItemClicked(id:Long){
        router.navigateTo(DetailsScreen(id))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}