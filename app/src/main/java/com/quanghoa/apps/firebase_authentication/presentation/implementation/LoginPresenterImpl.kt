package com.quanghoa.apps.firebase_authentication.presentation.implementation

import com.quanghoa.apps.firebase_authentication.common.isEmailValid
import com.quanghoa.apps.firebase_authentication.common.isPasswordValid
import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.model.LoginRequest
import com.quanghoa.apps.firebase_authentication.presentation.LoginPresenter
import com.quanghoa.apps.firebase_authentication.ui.login.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface
) : LoginPresenter {

    private lateinit var view: LoginView

    private val loginRequest = LoginRequest()

    override fun onLoginTapped() {
        if (loginRequest.isValid()) {
            authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
                if (isSuccess) {
                    view.onLoginSuccess()
                } else {
                    view.showLoginError()
                }
            }
        }
    }

    override fun onEmailChanged(email: String) {
        loginRequest.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        loginRequest.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun setView(view: LoginView) {
        this.view = view
    }

}