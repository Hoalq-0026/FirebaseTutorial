package com.quanghoa.apps.firebase_authentication.firebase.database

import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.model.User

interface FirebaseDatabaseInterface {

    fun listToJokes(onResult: (Joke) -> Unit)

    fun addNewJoke(joke: Joke, onResult: (Boolean) -> Unit)

    fun getFavoriteJokes(userId: String, onResult: (List<Joke>) -> Unit)

    fun changeJokeFavoriteStatus(joke: Joke, userId: String)

    fun createUser(id: String, name: String, email: String)

    fun getProfile(id: String, onResult: (User) -> Unit)
}
