package com.quanghoa.apps.firebase_authentication.presentation.implementation

import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.firebase.database.FirebaseDatabaseInterface
import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.presentation.FavoriteJokesPresenter
import com.quanghoa.apps.firebase_authentication.ui.jokes.favorite.FavoriteView
import javax.inject.Inject

class FavoriteJokesPresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : FavoriteJokesPresenter {

    private lateinit var view: FavoriteView

    override fun getFavoriteJokes() {
        val id = authenticationInterface.getUserId()

        databaseInterface.getFavoriteJokes(id) {
            it.forEach { it.isFavorite = true }
            displayItems(it)
        }
    }

    override fun onFavoriteButtonTapped(joke: Joke) {
        databaseInterface.changeJokeFavoriteStatus(joke, authenticationInterface.getUserId())
    }

    override fun setView(view: FavoriteView) {
        this.view = view
        getFavoriteJokes()
    }

    private fun displayItems(items: List<Joke>) {
        if (items.isEmpty()) {
            view.clearItems()
            view.showNoDataDescription()
        } else {
            view.hideNoDataDescription()
            view.showFavoriteJokes(items)
        }
    }
}