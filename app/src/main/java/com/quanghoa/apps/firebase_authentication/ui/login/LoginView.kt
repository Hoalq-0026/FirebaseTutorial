package com.quanghoa.apps.firebase_authentication.ui.login

interface LoginView{

    fun showPasswordError()

    fun showEmailError()

    fun onLoginSuccess()

    fun showLoginError()
}