package ru.chistov.mvp


class CountersPresenter(private val view: MainView, private val model: CountersModel) {

    fun onCounterClickBtnOne() {
        view.setButtonTextOne(model.next(ID_BUTTON_ONE).toString())
    }

    fun onCounterClickBtnTwo() {
        view.setButtonTextTwo(model.next(ID_BUTTON_TWO).toString())
    }

    fun onCounterClickBtnThee() {
        view.setButtonTextThee(model.next(ID_BUTTON_THEE).toString())
    }

}