package com.quanghoa.apps.firebase_authentication.ui.jokes.all

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.allJokesPresenter
import com.quanghoa.apps.firebase_authentication.model.Joke
import com.quanghoa.apps.firebase_authentication.ui.jokes.all.list.JokeAdapter
import kotlinx.android.synthetic.main.fragment_jokes.*

class AllJokesFragment : Fragment(), AllJokesView {

    private val presenter by lazy { allJokesPresenter() }
    private val adapter by lazy { JokeAdapter(presenter::onFavoriteButtonTapped) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        presenter.setView(this)

        presenter.viewReady()
    }

    private fun initUi() {
        jokes.layoutManager = LinearLayoutManager(activity)
        jokes.setHasFixedSize(true)
        jokes.adapter = adapter
    }

    override fun showNoDataDescription() {
        noItems.visibility = View.VISIBLE
    }

    override fun hideNoDataDescription() {
        noItems.visibility = View.GONE
    }

    override fun addJoke(joke: Joke) {
        adapter.addJoke(joke)
        noItems.visibility = if (adapter.itemCount != 0) View.INVISIBLE else View.VISIBLE
    }

    override fun setFavoriteJokesIds(favoriteJokesIds: List<String>) = adapter.setFavoriteJokesIds(favoriteJokesIds)

}