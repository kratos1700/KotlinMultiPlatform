package org.example.dragonball

import android.app.Application
import org.example.dragonball.di.initKoin
import org.example.dragonball.di.uiModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger


class DragonBallApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(extraModules = listOf(uiModule),config = {
            androidLogger()
            androidContext(this@DragonBallApp)
        })
    }
}