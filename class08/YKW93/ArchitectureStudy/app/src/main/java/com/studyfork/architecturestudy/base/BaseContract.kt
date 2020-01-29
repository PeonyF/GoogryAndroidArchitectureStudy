package com.studyfork.architecturestudy.base

import io.reactivex.disposables.Disposable

interface BaseContract {
    interface View {
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun subscribe(disposable: Disposable)
        fun unsubscribe()
    }
}