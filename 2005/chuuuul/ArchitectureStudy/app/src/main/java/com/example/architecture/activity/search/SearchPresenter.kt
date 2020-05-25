package com.example.architecture.activity.search

import android.util.Log
import android.view.inputmethod.EditorInfo
import com.example.architecture.R
import com.example.architecture.data.model.MovieModel
import com.example.architecture.data.repository.NaverRepository

class SearchPresenter(
    private val view: SearchContract.View,
    private val naverRepository: NaverRepository
) : SearchContract.Presenter {

    override fun searchMovie(keyword: String) {
        if (isValidKeyword(keyword)) {
            naverRepository.getMovieList(keyword, this::onSuccess, this::onFailure)
        }
    }

    private fun onSuccess(movieList: List<MovieModel>) {
        if (movieList.isNotEmpty()) {
            view.setMovieList(movieList)
        } else {
            view.showToast(R.string.not_found_result)
        }
    }

    private fun onFailure(t: Throwable) {
        Log.d("chul", "OnFailure : $t")
    }

    override fun searchMovie(actionId: Int, keyword: String): Boolean {
        return if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            searchMovie(keyword)
            true
        } else {
            false
        }
    }

    override fun isValidKeyword(keyword: String): Boolean {

        if (keyword.isBlank()) {
            view.showToast(R.string.empty_keyword)
            return false
        }
        return true
    }

    override fun clearLocalData(keyword: String) {
        naverRepository.clearCacheData()
    }

}

