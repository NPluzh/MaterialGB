package com.example.myapplication

import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //DynamicColors.applyToActivitiesIfAvailable(this)
    }
}