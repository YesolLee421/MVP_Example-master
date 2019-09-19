package com.hanmo.mvp_example.base


interface BaseView {

    // 에러 출력 부분이 공통적으로 쓰임
    fun showError(error : String)

}