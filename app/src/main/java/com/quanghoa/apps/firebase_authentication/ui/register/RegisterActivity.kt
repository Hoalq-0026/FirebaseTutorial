package com.quanghoa.apps.firebase_authentication.ui.register

import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.common.EMAIL_REGEX
import com.quanghoa.apps.firebase_authentication.common.onClick
import com.quanghoa.apps.firebase_authentication.common.onTextChanged
import com.quanghoa.apps.firebase_authentication.registerPresenter
import com.quanghoa.apps.firebase_authentication.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity(), RegisterView {

    private val presenter by lazy { registerPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        usernameInput.onTextChanged { presenter.onUsernameChanged(it) }
        emailInput.onTextChanged { presenter.onEmailChanged(it) }
        passwordInput.onTextChanged { presenter.onPasswordChanged(it) }
        repeatPasswordInput.onTextChanged { presenter.onRepeatPasswordChanged(it) }

        registerButton.onClick { presenter.onRegisterTapped() }
    }

    enum class EmailError(@StringRes val errorResource: Int) {
        NONE(0),
        EMPTY(R.string.email_empty_error),
        INVALID(R.string.email_error)
    }

    fun getError(context: Context, resource: Int) = if (resource == 0) null else context.getString(resource)

    private fun onEmailChanged(email: String): EmailError = when {
        email.isEmpty() -> EmailError.EMPTY
        !Pattern.matches(EMAIL_REGEX, email) -> EmailError.INVALID
        else -> EmailError.NONE
    }

    override fun onRegisterSuccess() {
        startActivity(MainActivity.getLaunchIntent(this))

    }

    override fun showSignUpError() {
    }

    override fun showUsernameError() {
        usernameInput.error = getString(R.string.username_error)
    }

    override fun showEmailError() {
        emailInput.error = getString(R.string.email_error)
    }

    override fun showPasswordError() {
        passwordInput.error = getString(R.string.password_error)
    }

    override fun showPasswordMatchingError() {
        repeatPasswordInput.error = getString(R.string.repeat_password_error)
    }

}