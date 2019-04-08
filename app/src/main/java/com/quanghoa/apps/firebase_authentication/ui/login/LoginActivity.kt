package com.quanghoa.apps.firebase_authentication.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.common.onClick
import com.quanghoa.apps.firebase_authentication.common.onTextChanged
import com.quanghoa.apps.firebase_authentication.common.showGeneralError
import com.quanghoa.apps.firebase_authentication.loginPresenter
import com.quanghoa.apps.firebase_authentication.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter by lazy { loginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.setView(this)
        initUi()
    }

    private fun initUi(){
        emailInput.onTextChanged { presenter.onEmailChanged(it) }
        passwordInput.onTextChanged { presenter.onPasswordChanged(it) }
        loginButton.onClick {  presenter.onLoginTapped() }
    }

    override fun showPasswordError() {
        passwordInput.error = getString(R.string.password_error)
    }

    override fun showEmailError() {
        emailInput.error = getString(R.string.email_error)
    }

    override fun onLoginSuccess() {
        startActivity(MainActivity.getLaunchIntent(this))
    }

    override fun showLoginError() = showGeneralError(this)

}