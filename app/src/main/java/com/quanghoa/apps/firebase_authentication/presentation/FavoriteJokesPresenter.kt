package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.ui.jokes.favorite.FavoriteView

interface FavoriteJokesPresenter : BasePresenter<FavoriteView> {

    fun getFavoriteJokes()

    fun onFavoriteButtonTapped(joke: Joke)
}