package ru.chistov.mvp.detailsUser

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.UserDetailsScreen
import ru.chistov.mvp.core.navigation.UsersScreen
import ru.chistov.mvp.disposeBy
import ru.chistov.mvp.repository.Interface.GithubRepository
import ru.chistov.mvp.subscribeByDefault
import javax.inject.Inject

class DetailsPresenter() : MvpPresenter<DetailsUserView>() {
    @Inject
    lateinit var repository: GithubRepository
    @Inject
    lateinit var router: Router
    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        repository.getUserById(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it)
                    viewState.hideLoading()
                }, {
                    Log.e("@@@", it.message.toString())
                }

            ).disposeBy(bag)


    }

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }

    fun onItemClicked(login: String) {
        router.navigateTo(UserDetailsScreen(login))
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

}