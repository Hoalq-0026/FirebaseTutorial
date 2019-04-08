package com.quanghoa.apps.firebase_authentication.firebase.database

import com.google.firebase.database.*
import com.quanghoa.apps.firebase_authentication.model.*
import javax.inject.Inject

private const val KEY_USER = "user"
private const val KEY_JOKE = "joke"
private const val KEY_FAVORITE = "favorite"

class FirebaseDataManager @Inject constructor(
    private val databse: FirebaseDatabase
) : FirebaseDatabaseInterface {

    override fun listToJokes(onJokeAdded: (Joke) -> Unit) {
        databse.reference.child(KEY_JOKE).orderByKey()
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
                    snapshot.getValue(JokeResponse::class.java)?.run {
                        if (isValid()) {
                            onJokeAdded(mapToJoke())
                        }
                    }
                }

                override fun onChildRemoved(p0: DataSnapshot) {
                }

            })

    }

    override fun addNewJoke(joke: Joke, onResult: (Boolean) -> Unit) {
        val newJokeReference = databse.reference.child(KEY_JOKE).push()
        val newJokeKey = newJokeReference.key
        if (newJokeKey != null) {
            val newJoke = joke.copy(id = newJokeKey)
            newJokeReference.setValue(newJoke).addOnCompleteListener {
                onResult(it.isSuccessful && it.isComplete)
            }
        }

    }

    override fun getFavoriteJokes(userId: String, onResult: (List<Joke>) -> Unit) {
        databse.reference
            .child(KEY_USER)
            .child(userId)
            .child(KEY_FAVORITE)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) = onResult(listOf())

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.run {
                        val jokes = children.mapNotNull {it.getValue(JokeResponse::class.java) }

                        onResult(jokes.map(JokeResponse::mapToJoke))
                    }
                }

            })

    }

    override fun changeJokeFavoriteStatus(joke: Joke, userId: String) {
        val reference = databse.reference
            .child(KEY_USER)
            .child(userId)
            .child(KEY_FAVORITE)
            .child(joke.id)

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val oldJoke = snapshot.getValue(JokeResponse::class.java)
                reference.setValue(
                    if (oldJoke != null) {
                        null
                    } else {
                        joke
                    })
            }

        })
    }

    override fun createUser(id: String, name: String, email: String) {
        val user = User(id, name, email)

        databse.reference
            .child(KEY_USER)
            .child(id)
            .setValue(user)
    }

    override fun getProfile(id: String, onResult: (User) -> Unit) {
        databse.reference
            .child(KEY_USER)
            .child(id)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(UserResponse::class.java)
                    val favoriteJokes = snapshot.child(KEY_FAVORITE).children
                        .map { it?.getValue(JokeResponse::class.java) }
                        .mapNotNull { it?.mapToJoke() }

                    user?.run {
                        onResult(User(id, username, email, favoriteJokes))
                    }
                }

            })
    }

}