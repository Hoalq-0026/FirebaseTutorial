package com.quanghoa.apps.firebase_authentication.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.common.onClick
import com.quanghoa.apps.firebase_authentication.ui.login.LoginActivity
import com.quanghoa.apps.firebase_authentication.ui.main.MainActivity
import com.quanghoa.apps.firebase_authentication.ui.register.RegisterActivity
import com.quanghoa.apps.firebase_authentication.welcomePresenter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), WelcomeView {

    private val presenter by lazy { welcomePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        presenter.setView(this)

        presenter.viewReady()

        registerButton.onClick { startActivity(Intent(this, RegisterActivity::class.java)) }
        loginButton.onClick { startActivity(Intent(this, LoginActivity::class.java)) }

    }

    override fun startMainScreen() = startActivity(MainActivity.getLaunchIntent(this))

}