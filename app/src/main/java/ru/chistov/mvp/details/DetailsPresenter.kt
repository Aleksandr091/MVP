package ru.chistov.mvp.details

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.chistov.mvp.core.navigation.UsersScreen
import ru.chistov.mvp.repository.Interface.GithubRepository
import ru.chistov.mvp.subscribeByDefault

class DetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<DetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun loadUser(id:Long){
        repository.getUserById(id)
            .subscribeByDefault()
            .subscribe(
                {viewState.show(it)
                },{
                    Log.e("@@@",it.message.toString())
                }

            )


    }

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }

}