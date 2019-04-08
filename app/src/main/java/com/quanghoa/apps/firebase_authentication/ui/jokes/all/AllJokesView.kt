package com.quanghoa.apps.firebase_authentication.ui.jokes.all

import com.quanghoa.apps.firebase_authentication.model.Joke

interface AllJokesView {

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun addJoke(joke: Joke)

    fun setFavoriteJokesIds(favoriteJokesIds: List<String>)
}