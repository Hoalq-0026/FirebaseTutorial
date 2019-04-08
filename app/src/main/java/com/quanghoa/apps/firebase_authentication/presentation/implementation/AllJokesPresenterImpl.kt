package com.quanghoa.apps.firebase_authentication.presentation.implementation

import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.firebase.database.FirebaseDatabaseInterface
import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.presentation.AllJokesPresenter
import com.quanghoa.apps.firebase_authentication.ui.jokes.all.AllJokesView
import javax.inject.Inject

class AllJokesPresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : AllJokesPresenter {

    private lateinit var view: AllJokesView


    override fun viewReady() {
        getAllJokes()
    }

    override fun getAllJokes() = databaseInterface.listToJokes { view.addJoke(it) }

    override fun onFavoriteButtonTapped(joke: Joke) {
        databaseInterface.changeJokeFavoriteStatus(joke, authenticationInterface.getUserId())
    }

    override fun setView(view: AllJokesView) {
        this.view = view
    }

}