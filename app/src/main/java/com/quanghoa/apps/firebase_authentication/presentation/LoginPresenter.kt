package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.ui.login.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginTapped()

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)
}