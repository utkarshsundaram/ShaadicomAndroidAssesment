package com.example.shaadicomandroidassesment.appplication

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.example.shaadicomandroidassesment.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShaadiApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin {
            // declare used Android context
            androidContext(this@ShaadiApplication)
            // declare modules
            modules(provideComponent())
        }

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}