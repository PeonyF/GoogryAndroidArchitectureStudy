package com.example.kangraemin.ui.login

import com.example.kangraemin.base.KangBasePresenter

interface LoginContract {
    interface View {
        fun showEmptyIdError()
        fun hideEmptyIdError()
        fun showPasswordEmptyError()
        fun hidePasswordEmptyError()
        fun showFailedLoginError()
        fun hideFailedLoginError()
        fun showAddAuthError()
        fun enableLoginButton()
        fun disableLoginButton()
        fun startMain()
    }

    interface Presenter : KangBasePresenter {
        fun checkIdIsEmpty(id: String, hasFocus: Boolean)
        fun checkPasswordIsEmpty(password: String, hasFocus: Boolean)
        fun checkLoginInfoHasEntered(id: String, password: String)
        fun login(id: String, password: String, isAutoLogin: Boolean)
    }
}