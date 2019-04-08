package com.quanghoa.apps.firebase_authentication.di.module

import com.quanghoa.apps.firebase_authentication.presentation.*
import com.quanghoa.apps.firebase_authentication.presentation.implementation.*
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {

    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter

    @Binds
    abstract fun registerPresenter(registerPresenter: RegisterPresenterImpl): RegisterPresenter

    @Binds
    abstract fun allJokesPresenter(allJokesPresenter: AllJokesPresenterImpl): AllJokesPresenter

    @Binds
    abstract fun favoriteJokesPresenter(favoriteJokesPresenter: FavoriteJokesPresenterImpl): FavoriteJokesPresenter

    @Binds
    abstract fun profilePresenter(profilePresenter: ProfilePresenterImpl): ProfilePresenter

    @Binds
    abstract fun addJokePresenter(addJokePresenter: AddJokePresenterImpl): AddJokePresenter

    @Binds
    abstract fun welcomePresenter(welcomePresenter: WelcomePresenterImpl): WelcomePresenter
}
