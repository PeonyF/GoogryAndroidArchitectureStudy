package com.example.myproject.data.sharedPreferences

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        prefs = Preferences(applicationContext)
    }

    companion object {
        lateinit var prefs: Preferences
    }
}
