package com.quanghoa.apps.firebase_authentication.presentation.implementation

import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.firebase.database.FirebaseDatabaseInterface
import com.quanghoa.apps.firebase_authentication.presentation.ProfilePresenter
import com.quanghoa.apps.firebase_authentication.ui.profile.ProfileView
import javax.inject.Inject

class ProfilePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : ProfilePresenter {

    private lateinit var view: ProfileView

    override fun getProfile() {
        databaseInterface.getProfile(authenticationInterface.getUserId()) {
            val userId = authenticationInterface.getUserId()

            view.showUsername(it.username)
            view.showEmail(it.email)
            view.showNumberOfJokes(it.favoriteJokes.count() { it.authorId == userId })
        }
    }

    override fun logOut() = authenticationInterface.logout {
        view.openWelcome()
    }

    override fun setView(view: ProfileView) {
        this.view = view
        getProfile()
    }

}