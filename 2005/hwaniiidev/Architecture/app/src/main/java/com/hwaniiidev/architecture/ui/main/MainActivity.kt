package com.hwaniiidev.architecture.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hwaniiidev.architecture.R
import com.hwaniiidev.architecture.data.repository.NaverMovieRepositoryImpl
import com.hwaniiidev.architecture.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainContract.View{

    private val TAG = MainActivity::class.java.simpleName

    lateinit var adapterMovieList: AdapterMovieList

    private val naverMovieRepositoryImpl = NaverMovieRepositoryImpl(this)
    private val mainPresenter = MainPresenter(this,naverMovieRepositoryImpl)

    lateinit private var imm: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        btn_search.setOnClickListener {
            val searchValue = edit_search_title.text.toString()
            mainPresenter.searchMovies(searchValue)

            /*if (edit_search_title.text.isEmpty()) {       //검색어 입력하지 않았을 때
                Log.d(TAG, "없음")
                toast("검색어를 입력해주세요.")
            } else {
                naverMovieRepositoryImpl.getRemoteMovies(
                    query = searchValue,
                    onSuccess = { response ->
                        hideKeyboard()

                        if (response.total == 0) {
                            text_plz_search.text = "검색결과가 없습니다.\n다른 검색어을 입력해주세요."
                            text_plz_search.visibility = View.VISIBLE
                        } else {
                            updateList(response.items)
                            text_plz_search.visibility = View.GONE

                            //Local DB에 저장
                            if (!this.isFinishing && !this.isDestroyed){
                                naverMovieRepositoryImpl.cachingMovies(
                                    query = response.query,
                                    movies = response.items
                                )
                            }

                        }
                    },
                    onError = { errorMessage ->
                        toast("다시 시도해주세요.")
                        Log.d(TAG, errorMessage)
                    },
                    onFailure = { t ->
                        toast("네트워크에 연결할 수 없습니다. 네트워크 연결을 확인해주세요.")
                        Log.d(TAG, t.toString())
                    }
                )
            }*/
        }
    }

    private fun initView() {
        adapterMovieList = AdapterMovieList()
        recyclerview_search_list.adapter = adapterMovieList
    }

    /*private fun updateList(items: List<Item>) {
        adapterMovieList.addItem(items)
    }*/

    private fun toast(message: String) {
        Toast.makeText(
            this@MainActivity,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun showQueryIsEmpty() {
        toast("검색어를 입력해주세요.")
        Log.d(TAG, "없음")
    }

    override fun hideKeyBoard() {
        imm.hideSoftInputFromWindow(edit_search_title.windowToken, 0)
    }

    override fun showResponseIsNone() {
        text_plz_search.text = "검색결과가 없습니다.\n다른 검색어을 입력해주세요."
        text_plz_search.visibility = View.VISIBLE
    }

    override fun showResponseError() {
        toast("다시 시도해주세요.")
    }

    override fun showNetworkFailure() {
        toast("네트워크에 연결할 수 없습니다. 네트워크 연결을 확인해주세요.")
    }

    override fun showMoviesList(items: List<Item>) {
        adapterMovieList.addItem(items)
        text_plz_search.visibility = View.GONE
    }
}
