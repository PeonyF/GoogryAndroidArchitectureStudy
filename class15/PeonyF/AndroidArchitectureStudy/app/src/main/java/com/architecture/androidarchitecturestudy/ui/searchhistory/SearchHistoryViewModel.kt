package com.architecture.androidarchitecturestudy.ui.searchhistory

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architecture.androidarchitecturestudy.data.model.SearchHistoryEntity
import com.architecture.androidarchitecturestudy.data.repository.MovieRepository

class SearchHistoryViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    val keywordList = MutableLiveData<List<SearchHistoryEntity>>()
    fun getRecentKeywordList() {
        keywordList.value = movieRepository.getSearchHistoryList()
    }
}