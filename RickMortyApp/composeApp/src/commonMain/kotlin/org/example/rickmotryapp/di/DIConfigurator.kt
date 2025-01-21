package org.example.rickmotryapp.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

/**
 * Koin modules for the app para inyectar dependencias en la parte de IOS y ANDROID
 */
expect fun platformModule(): Module

/*
 * Initializes Koin modules, which are used to inject dependencies into the app.
 * config: KoinAppDeclaration? = null: a lambda that configures Koin
 */
fun initKoin(config: KoinAppDeclaration? = null) {
    // Start Koin
    startKoin {
        config?.invoke(this)  // esto sirve para que se pueda pasar un lambda con la configuración de Koin
        modules(
            uiModule,
            dataModule,
            domainModule,
            platformModule()  // se añade el módulo específico de la plataforma

        )
    }

}