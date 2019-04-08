package com.quanghoa.apps.firebase_authentication.ui.jokes.all.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.common.onClick
import com.quanghoa.apps.firebase_authentication.model.Joke
import kotlinx.android.synthetic.main.item_joke.view.*

class JokeHolder(
    itemView: View,
    private inline val onFavoriteClickHandler: (Joke) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun displayData(joke: Joke) = with(itemView) {
        favoriteButton.onClick {
            joke.isFavorite = !joke.isFavorite
            onFavoriteClickHandler(joke)
            favoriteButton.setImageResource(if (joke.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border)
        }
        jokeAuthor.text = joke.authorName
        jokeDescription.text = joke.text


        favoriteButton.setImageResource(if (joke.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border)
    }

}