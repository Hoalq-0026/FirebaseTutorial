package com.quanghoa.apps.firebase_authentication.presentation

interface BasePresenter<in T>{

    fun setView(view: T)
}