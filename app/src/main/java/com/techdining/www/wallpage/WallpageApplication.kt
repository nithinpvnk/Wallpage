package com.techdining.www.wallpage

import android.app.Application
import timber.log.Timber

class WallpageApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}