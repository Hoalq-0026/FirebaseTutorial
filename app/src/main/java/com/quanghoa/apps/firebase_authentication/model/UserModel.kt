package com.quanghoa.apps.firebase_authentication.model

data class UserResponse(val id: String = "",
                        val username: String = "",
                        val email: String = "",
                        val favoriteJokes: List<Joke> = listOf())

data class User(val id: String,
                val username: String,
                val email: String,
                val favoriteJokes: List<Joke> = listOf())