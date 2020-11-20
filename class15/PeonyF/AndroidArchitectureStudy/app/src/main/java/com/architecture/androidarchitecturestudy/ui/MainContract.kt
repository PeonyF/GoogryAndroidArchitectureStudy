package com.architecture.androidarchitecturestudy.ui

import com.architecture.androidarchitecturestudy.data.model.Movie

interface MainContract {
    interface View {
        fun removeKeyboard()
        fun updateMovieRecycler(items: List<Movie>)
        fun failMovieGet(msg: String)
        fun noQuery()
        fun noResult()
    }

    interface Presenter {
        fun findMovie(query: String)
    }
}
