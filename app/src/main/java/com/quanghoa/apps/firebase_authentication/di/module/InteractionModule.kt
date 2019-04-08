package com.quanghoa.apps.firebase_authentication.di.module

import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationInterface
import com.quanghoa.apps.firebase_authentication.firebase.authentication.FirebaseAuthenticationManager
import com.quanghoa.apps.firebase_authentication.firebase.database.FirebaseDataManager
import com.quanghoa.apps.firebase_authentication.firebase.database.FirebaseDatabaseInterface
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [FirebaseModule::class])
@Singleton
abstract class InteractionModule {

    @Binds
    abstract fun authentication(authentication: FirebaseAuthenticationManager): FirebaseAuthenticationInterface

    @Binds
    abstract fun database(database: FirebaseDataManager): FirebaseDatabaseInterface
}