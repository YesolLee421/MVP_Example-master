package com.hanmo.mvp_example.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.hanmo.mvp_example.R
import com.hanmo.mvp_example.base.BaseActivity
import com.hanmo.mvp_example.model.Dog
import com.hanmo.mvp_example.presenter.SearchContract
import com.hanmo.mvp_example.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity(), SearchContract.View {

    // 일대일 대응하는 presenter 연결하기 위한 초기화 지연 변수(?) 객체 선언
    private lateinit var searchPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // presenter와 현재 뷰 연결
        searchPresenter.takeView(this)

        setButton()

    }

    private fun setButton() {
        getDogListButton.setOnClickListener {
            searchPresenter.getDogList()
            //presenter에 이벤트 발생 알리기->presenter가 모델에서 데이터 가져옴
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showDogList(dogList : List<Dog>) {
        // 모델에서 받은 데이터를 presenter에서 view로 전달, textView에 띄우기
        firstDogText.text = "Name : ${dogList[0].name}, Age : ${dogList[0].age}"
        secondDogText.text = "Name : ${dogList[1].name}, Age : ${dogList[1].age}"
        thirdDogText.text = "Name : ${dogList[2].name}, Age : ${dogList[2].age}"
        fourthDogText.text = "Name : ${dogList[3].name}, Age : ${dogList[3].age}" //추가
    }

    override fun onDestroy() {
        super.onDestroy()
        searchPresenter.dropView() // view 연결 해제
    }

    // baseActivity에서 activity가 생성되면 해당 액티비티 presenter 초기화
    override fun initPresenter() {
        searchPresenter = SearchPresenter()
    }

    override fun showError(error: String) { // 에러 시 메시지
        Toast.makeText(this@SearchActivity, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() { // 프로그래스 바 보이기
        searchRefresh.visibility = View.VISIBLE
    }

    override fun hideLoading() { // 프로그래스 바 감추기
        searchRefresh.visibility = View.GONE
    }

}
