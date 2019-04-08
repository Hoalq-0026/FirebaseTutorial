package com.quanghoa.apps.firebase_authentication.ui.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.quanghoa.apps.firebase_authentication.R
import com.quanghoa.apps.firebase_authentication.common.onClick
import com.quanghoa.apps.firebase_authentication.common.onPageChange
import com.quanghoa.apps.firebase_authentication.ui.addJoke.AddJokeActivity
import com.quanghoa.apps.firebase_authentication.ui.jokes.all.AllJokesFragment
import com.quanghoa.apps.firebase_authentication.ui.jokes.favorite.FavoriteJokesFragment
import com.quanghoa.apps.firebase_authentication.ui.main.pager.MainPagerAdapter
import com.quanghoa.apps.firebase_authentication.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
    }

    private fun initUi() {
        val adapter = MainPagerAdapter(supportFragmentManager)
        adapter.setPages(listOf(AllJokesFragment(), FavoriteJokesFragment(), ProfileFragment()))

        mainPager.adapter = adapter
        mainPager.offscreenPageLimit = 3
        bottomNavigation.setOnNavigationItemSelectedListener {
            switchNavigationTab(it.order)
            true
        }

        mainPager.onPageChange { position ->
            val item = bottomNavigation.menu.getItem(position)
            bottomNavigation.selectedItemId = item.itemId
        }

        addJoke.onClick { startActivity(Intent(this, AddJokeActivity::class.java)) }
    }

    private fun switchNavigationTab(position: Int) = mainPager.setCurrentItem(position, true)
}
