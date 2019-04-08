package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.ui.register.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {

    fun onUsernameChanged(username: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterTapped()
}