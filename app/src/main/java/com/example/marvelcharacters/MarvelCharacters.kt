package com.example.marvelcharacters

import android.app.Application
import com.github.ajalt.timberkt.Timber
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelCharacters() : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
