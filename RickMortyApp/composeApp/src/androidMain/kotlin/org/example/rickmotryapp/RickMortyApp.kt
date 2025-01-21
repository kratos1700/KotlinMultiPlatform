package org.example.rickmotryapp

import android.app.Application
import org.example.rickmotryapp.di.initKoin

class RickMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}