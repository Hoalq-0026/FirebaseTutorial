package com.quanghoa.apps.firebase_authentication

import android.app.Application
import com.quanghoa.apps.firebase_authentication.di.AppComponent
import com.quanghoa.apps.firebase_authentication.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        val component: AppComponent by lazy {
            DaggerAppComponent.builder().build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}