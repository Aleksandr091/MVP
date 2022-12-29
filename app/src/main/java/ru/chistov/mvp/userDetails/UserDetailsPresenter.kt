package ru.chistov.mvp.userDetails

import android.os.Bundle
import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.RepoDetailsScreen
import ru.chistov.mvp.core.navigation.UserDetailsScreen
import ru.chistov.mvp.core.navigation.UsersScreen
import ru.chistov.mvp.disposeBy
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.repository.Interface.GithubRepository
import ru.chistov.mvp.subscribeByDefault

class UserDetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserDetailsView>() {

    private val bag = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
    fun loadRepo(login: String) {
        viewState.showLoading()
        repository.getReposByUsers(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                }, {
                    Log.e("@@@", it.message.toString())
                }

            ).disposeBy(bag)


    }

    fun onItemClicked(bundle: Bundle) {
        router.navigateTo(RepoDetailsScreen(bundle))
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