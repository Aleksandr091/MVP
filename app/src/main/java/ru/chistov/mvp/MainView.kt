package ru.chistov.mvp

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun setButtonTextOne(counter: String)
    fun setButtonTextTwo(counter: String)
    fun setButtonTextThee(counter: String)
}