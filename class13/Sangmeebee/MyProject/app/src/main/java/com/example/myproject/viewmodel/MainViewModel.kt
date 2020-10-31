package com.example.myproject.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.data.model.Items
import com.example.myproject.data.repository.NaverRepository
import com.example.myproject.data.repository.NaverRepositoryImpl
import com.example.myproject.data.source.local.NaverLocalDataSourceImpl
import com.example.myproject.data.source.remote.NaverRemoteDataSourceImpl

class MainViewModel @ViewModelInject constructor(private val repository: NaverRepository) : ViewModel() {

    val query = MutableLiveData<String>()
    val movieList = MutableLiveData<List<Items>>()
    val titleList = MutableLiveData<List<String>>()
    val showDialog = MutableLiveData<Boolean>(false)
    var msg = MutableLiveData<String>()
    var isVisibleToast = true

    fun callMovieList() {
        isVisibleToast = true
        val query = query.value
        if (query.isNullOrEmpty()) {
            msg.value = "empty"
        } else {
            repository.getMovieList(query, {
                if (it.isEmpty()) {
                    msg.value = "empty_result"
                } else {
                    msg.value = "success"
                    movieList.value = it
                }
            }, {
                msg.value = "error"
            })
        }
    }

    fun callDialog() {
        showDialog.value = true
    }

    fun callTitleList() {
        titleList.value = repository.readRecentSearchTitle()
    }
}
