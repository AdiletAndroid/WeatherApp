package com.example.rawgapp.common.mvp

interface MvpPresenter<V : MvpView> {

    fun attach(view: V)

    fun detach()
}