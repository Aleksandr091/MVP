package ru.chistov.mvp

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CountersPresenter( private val model: CountersModel) : MvpPresenter<MainView>() {

    fun onCounterClickBtnOne() {
        viewState.setButtonTextOne(model.next(ID_BUTTON_ONE).toString())
    }

    fun onCounterClickBtnTwo() {
        viewState.setButtonTextTwo(model.next(ID_BUTTON_TWO).toString())
    }

    fun onCounterClickBtnThee() {
        viewState.setButtonTextThee(model.next(ID_BUTTON_THEE).toString())
    }

}