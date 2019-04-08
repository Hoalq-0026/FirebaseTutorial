package com.quanghoa.apps.firebase_authentication.ui.jokes.favorite.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.ui.jokes.all.list.JokeHolder

class FavoriteJokeAdapter(
        private val onFavoriteClickHandler: (Joke) -> Unit
) : RecyclerView.Adapter<JokeHolder>() {

    private val items = mutableListOf<Joke>()

    fun setData(data: List<Joke>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeHolder(view, onFavoriteClickHandler)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: JokeHolder, position: Int) = holder.displayData(items[position])

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

}