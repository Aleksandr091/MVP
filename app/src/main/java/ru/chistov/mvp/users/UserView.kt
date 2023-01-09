package ru.chistov.mvp.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.chistov.mvp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {

    fun initList(list: List<GithubUser>)

    fun showLoading()

    fun hideLoading()
}