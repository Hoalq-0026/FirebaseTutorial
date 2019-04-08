package com.quanghoa.apps.firebase_authentication.presentation

import com.quanghoa.apps.firebase_authentication.ui.addJoke.AddJokeView

interface AddJokePresenter : BasePresenter<AddJokeView> {

    fun addJokeTapped()

    fun onJokeTextChanged(jokeText: String)
}