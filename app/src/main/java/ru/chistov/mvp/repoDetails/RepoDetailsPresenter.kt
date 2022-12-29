package ru.chistov.mvp.repoDetails

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.RepoDetailsScreen
import ru.chistov.mvp.core.navigation.UserDetailsScreen

import ru.chistov.mvp.repository.Interface.GithubRepository


class RepoDetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<RepoDetailsView>() {

    private val bag = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }


    fun onBackPressed(login: String): Boolean {
        router.backTo(UserDetailsScreen(login))
        return true
    }




    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

}