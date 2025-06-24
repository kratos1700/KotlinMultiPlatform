package org.example.dragonball.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
/*
    Per iniciar Koin,  startKoin() en el main de la app.
 */


//per a ios
fun initKoin() = initKoin(extraModules = emptyList(), config = null)


// per a android
fun initKoin(extraModules: List<Module>, config: KoinAppDeclaration?) {
    startKoin {
        config?.invoke(this)
        modules(
            dataModule,
            *extraModules.toTypedArray()
        )
    }
}