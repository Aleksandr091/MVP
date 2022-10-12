package ru.chistov.mvp.user

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.DetailsScreen
import ru.chistov.mvp.disposeBy
import ru.chistov.mvp.repository.Interface.GithubRepository
import ru.chistov.mvp.subscribeByDefault

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
            .subscribeByDefault()
            .subscribe(
                {viewState.initList(it)
                    viewState.hideLoading()
                },{
                    Log.e("@@@",it.message.toString())
                }

        )
    }

    fun onItemClicked(id:Long){
        router.navigateTo(DetailsScreen(id))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}