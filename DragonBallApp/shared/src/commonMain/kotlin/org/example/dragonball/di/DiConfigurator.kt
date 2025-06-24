package org.example.dragonball.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module

/*
    Per iniciar Koin,  startKoin() en el main de la app.
 */


//per a ios
fun initKoin()= initKoin(emptyList())



// per a android
fun initKoin(extraModules: List<Module>) {
    startKoin {
        modules(
            dataModule,
            *extraModules.toTypedArray() // Convertimos la lista a un array para pasarlo como vararg
        )
    }
}