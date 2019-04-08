package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.ui.welcome.WelcomeView

interface WelcomePresenter : BasePresenter<WelcomeView> {

    fun viewReady()
}