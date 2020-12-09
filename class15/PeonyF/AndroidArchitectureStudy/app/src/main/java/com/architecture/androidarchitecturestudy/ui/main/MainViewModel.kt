package com.architecture.androidarchitecturestudy.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architecture.androidarchitecturestudy.data.model.Movie
import com.architecture.androidarchitecturestudy.data.repository.MovieRepository

class MainViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val keyword = MutableLiveData<String>()
    val movieList = MutableLiveData<List<Movie>>()
    val msg = MutableLiveData<String>()
    val callSearchHistory = MutableLiveData<Unit>()
    var isVisibleToast = true


    fun findMovie() {
        val keyword = keyword.get() ?: return
        if (keyword.isNullOrBlank()) {
            msg.set("emptyKeyword")
            showToastMsg.notifyChange()
            return
        }
        movieRepository.getMovieData(keyword = keyword, 30,
            onSuccess = {
                if (it.items!!.isEmpty()) {
                    msg.set("emptyResult")
                    showToastMsg.notifyChange()
                } else {
                    msg.set("success")
                    movieList.set(it.items)
                }
            },
            onFailure = {
                msg.set("fail")
                showToastMsg.notifyChange()
            }
        )
    }

    fun searchHistory() {
        callSearchHistory.notifyChange()
    }
}