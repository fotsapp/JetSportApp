package com.fots.jetsport;

import android.app.Application;
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author: fevziomurtekin
 * @date: 22/04/2021
 */

@HiltAndroidApp
class JetSportApp: Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}