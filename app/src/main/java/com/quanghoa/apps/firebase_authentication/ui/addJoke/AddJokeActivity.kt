package com.quanghoa.apps.firebase_authentication.ui.addJoke

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.addJokePresenter
import com.quanghoa.apps.firebase_authentication.common.onClick
import com.quanghoa.apps.firebase_authentication.common.onTextChanged
import com.quanghoa.apps.firebase_authentication.common.showGeneralError
import kotlinx.android.synthetic.main.activity_add_joke.*

class AddJokeActivity : AppCompatActivity(), AddJokeView {

    private val presenter by lazy { addJokePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_joke)
        presenter.setView(this)
        initUi()

    }

    private fun initUi() {
        jokeDescription.onTextChanged { presenter.onJokeTextChanged(it) }
        addJoke.onClick { presenter.addJokeTapped() }
    }

    override fun onJokeAdded() = this.finish()

    override fun showAddJokeError() = showGeneralError(this)

    override fun showJokeError() {
        jokeDescription.error = getString(R.string.joke_error)
    }

    override fun removeJokeError() {
        jokeDescription.error = null
    }

}