package com.hanmo.mvp_example.base

interface BasePresenter<T> {

    // view가 생성 혹은 bind 될 때를 Presenter에 전달
    fun takeView(view: T)

    // view가 제거되거나 unbind될 때 presenter에 전달
    fun dropView()

}