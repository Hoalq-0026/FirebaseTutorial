package com.quanghoa.apps.firebase_authentication.ui.jokes.all.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.model.Joke

class JokeAdapter(
        private val onFavoriteClickHandler: (Joke) -> Unit
) : RecyclerView.Adapter<JokeHolder>() {

    private val items = mutableListOf<Joke>()
    private val favoritesJokesIds = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeHolder(view, onFavoriteClickHandler)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: JokeHolder, position: Int) {

        val joke = items[position].apply { isFavorite = id in favoritesJokesIds }

        holder.displayData(joke)
    }

    fun addJoke(joke: Joke) {
        items.add(joke)
        notifyItemInserted(items.size - 1)
    }

    fun setFavoriteJokesIds(ids: List<String>) {
        favoritesJokesIds.clear()
        favoritesJokesIds.addAll(ids)
        notifyDataSetChanged()
    }

}