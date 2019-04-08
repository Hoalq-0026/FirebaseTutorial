package com.quanghoa.apps.firebase_authentication.presentation.implementation

import com.quanghoa.apps.firebase_authentication.common.isValidJoke
import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.firebase.database.FirebaseDatabaseInterface
import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.presentation.AddJokePresenter
import com.quanghoa.apps.firebase_authentication.ui.addJoke.AddJokeView
import javax.inject.Inject

class AddJokePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : AddJokePresenter {

    private lateinit var view: AddJokeView

    private var jokeText = ""

    override fun addJokeTapped() {
        if (isValidJoke(jokeText)) {
            val joke = Joke("", authenticationInterface.getUserName(), authenticationInterface.getUserId(), jokeText)

            databaseInterface.addNewJoke(joke) {
                addJokeResult(it)
            }
        }
    }

    override fun onJokeTextChanged(jokeText: String) {
        this.jokeText = jokeText

        if (!isValidJoke(jokeText)) {
            view.showJokeError()
        } else {
            view.removeJokeError()
        }
    }

    override fun setView(view: AddJokeView) {
        this.view = view
    }

    private fun addJokeResult(isSuccessful: Boolean) {
        if (isSuccessful) {
            view.onJokeAdded()
        } else {
            view.showAddJokeError()
        }
    }
}