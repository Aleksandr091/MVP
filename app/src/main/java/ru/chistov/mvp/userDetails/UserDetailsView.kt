package ru.chistov.mvp.userDetails

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.chistov.mvp.model.GithubUserRepo

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : MvpView {

    fun initList(list: List<GithubUserRepo>)

    fun showLoading()

    fun hideLoading()
}