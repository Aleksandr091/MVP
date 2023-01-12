package ru.chistov.mvp.users

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.DetailsScreen
import ru.chistov.mvp.disposeBy
import ru.chistov.mvp.repository.Interface.GithubRepository
import ru.chistov.mvp.subscribeByDefault
import javax.inject.Inject

class UserPresenter() : MvpPresenter<UserView>() {
    @Inject
    lateinit var repository: GithubRepository
    @Inject
    lateinit var router: Router

    private val bag = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
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

    fun onItemClicked(login: String) {
        router.navigateTo(DetailsScreen(login))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

}