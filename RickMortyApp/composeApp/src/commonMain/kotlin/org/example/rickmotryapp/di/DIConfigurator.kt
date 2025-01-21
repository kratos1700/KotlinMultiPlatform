package org.example.rickmotryapp.di

import org.koin.core.context.startKoin

/*
 * Initializes Koin modules, which are used to inject dependencies into the app.
 */
fun initKoin() {
    // Start Koin
    startKoin {
        modules(uiModule,
            dataModule,
            domainModule)
    }

}