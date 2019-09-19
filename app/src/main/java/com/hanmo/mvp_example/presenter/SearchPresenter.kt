package com.hanmo.mvp_example.presenter

import android.os.Handler
import com.hanmo.mvp_example.model.DogListData

class SearchPresenter : SearchContract.Presenter {

    private var searchView : SearchContract.View? = null

    // view-presenter연결
    override fun takeView(view: SearchContract.View) {
        searchView = view
    }

    // presenter의 데이터 가져와서 정제하는 메소드 오버라이드
    override fun getDogList() {
        // 뷰에서 프로그래스 바 보여주기 시작
        searchView?.showLoading()

        Handler().postDelayed({
            // model에서 dogList전달받기
            val dogList = DogListData.getDoglistData()
            // 모델에서 전달받은 데이터를 뷰에 전달
            searchView?.showDogList(dogList)
            // 전달하고 나면 프로그래스바 감추기
            searchView?.hideLoading()
        }, 1000)
    }

    // view가 제거된 것을 presenter에 알려준다.
    override fun dropView() {
        searchView = null
    }

}