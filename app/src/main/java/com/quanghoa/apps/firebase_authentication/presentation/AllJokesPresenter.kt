package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.ui.jokes.all.AllJokesView

interface AllJokesPresenter : BasePresenter<AllJokesView> {

    fun viewReady()

    fun getAllJokes()

    fun onFavoriteButtonTapped(joke: Joke)
}