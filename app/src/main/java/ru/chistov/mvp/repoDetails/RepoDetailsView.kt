package ru.chistov.mvp.repoDetails

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.chistov.mvp.model.GithubUserRepo

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepoDetailsView : MvpView {
    fun show(repo: GithubUserRepo)

    fun showLoading()

    fun hideLoading()

}