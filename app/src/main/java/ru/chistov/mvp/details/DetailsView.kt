package ru.chistov.mvp.details

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.chistov.mvp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView : MvpView {
    fun show(user: GithubUser)

    fun showLoading()

    fun hideLoading()

}