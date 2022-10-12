package ru.chistov.mvp.details

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.UsersScreen
import ru.chistov.mvp.repository.Interface.GithubRepository

class DetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<DetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun loadUser(id:Long){
        val user = repository.getUserById(id)
        if (user != null) {
            viewState.show(user)
        }


    }

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }

}