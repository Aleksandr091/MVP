package ru.chistov.mvp

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

const val ID_BUTTON_ONE = 0
const val ID_BUTTON_TWO = 1
const val ID_BUTTON_THEE = 2
const val ID = "ID"



fun <T> Single<T>.subscribeByDefault():Single<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.disposeBy(bag: CompositeDisposable){
    bag.add(this)
}