package com.hanmo.mvp_example.presenter

import com.hanmo.mvp_example.base.BasePresenter
import com.hanmo.mvp_example.base.BaseView
import com.hanmo.mvp_example.model.Dog

interface SearchContract {
    // view와 presenter가 구현해야 할 인터페이스를 정의하는 contract 구현

    // BaseView 상속받는 view 인터페이스 작성
    interface View : BaseView {
        fun showLoading() // 데이터 받아서 정제하는 동안 보일 progressBar관리
        fun hideLoading()
        fun showDogList(dogList : List<Dog>) // 정제한 데이터를 Presenter에서 전달받을 함수
    }

    // basePresenter 상속받는 presenter 인터페이스 작성
    interface Presenter : BasePresenter<View> {
        fun getDogList() // model로부터 데이터 받아오기(+정제)위한 함수
    }

}