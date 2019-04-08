package com.quanghoa.apps.firebase_authentication.presentation.implementation

import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.presentation.WelcomePresenter
import com.quanghoa.apps.firebase_authentication.ui.welcome.WelcomeView
import javax.inject.Inject

class WelcomePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface
) : WelcomePresenter {

    private lateinit var view: WelcomeView

    override fun viewReady() {
        if (authenticationInterface.getUserId().isNotBlank()) {
            view.startMainScreen()
        }

    }

    override fun setView(view: WelcomeView) {
        this.view = view
    }

}