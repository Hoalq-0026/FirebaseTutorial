package com.quanghoa.apps.firebase_authentication.di

import com.quanghoa.apps.firebase_authentication.di.module.PresentationModule
import com.quanghoa.apps.firebase_authentication.presentation.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {


    fun registerPresenter(): RegisterPresenter

    fun loginPresenter(): LoginPresenter

    fun allJokesPresenter(): AllJokesPresenter

    fun favoriteJokesPresenter(): FavoriteJokesPresenter

    fun profilePresenter(): ProfilePresenter

    fun addJokePresenter(): AddJokePresenter

    fun welcomePresenter(): WelcomePresenter
}