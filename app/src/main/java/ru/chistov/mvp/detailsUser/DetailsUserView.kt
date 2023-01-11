package ru.chistov.mvp.detailsUser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.chistov.mvp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsUserView : MvpView {
    fun show(user: GithubUser)

    fun showLoading()

    fun hideLoading()

}