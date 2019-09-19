package com.hanmo.mvp_example.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    // View와 상호작용할 presenter 선언
    abstract fun initPresenter()

}