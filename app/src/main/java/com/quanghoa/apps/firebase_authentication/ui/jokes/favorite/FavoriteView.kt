package com.quanghoa.apps.firebase_authentication.ui.jokes.favorite

import com.quanghoa.apps.firebase_authentication.model.Joke

interface FavoriteView{

    fun showFavoriteJokes(jokes: List<Joke>)

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun clearItems()
}