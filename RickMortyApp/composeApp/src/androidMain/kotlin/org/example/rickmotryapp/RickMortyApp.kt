package org.example.rickmotryapp

import android.app.Application
import org.example.rickmotryapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RickMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidLogger() // Koin Android Logger para depuración
            androidContext(this@RickMortyApp) // Contexto de la aplicación para Koin

        }
    }
}