package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.ui.profile.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {

    fun getProfile()

    fun logOut()
}