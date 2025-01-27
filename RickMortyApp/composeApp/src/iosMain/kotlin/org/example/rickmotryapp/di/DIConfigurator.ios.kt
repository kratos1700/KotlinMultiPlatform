package org.example.rickmotryapp.di

import org.example.rickmotryapp.data.database.RickMortyDatabase
import org.example.rickmotryapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

/*
 * Koin modules for the app para inyectar dependencias en la parte de IOS
 */
actual fun platformModule(): Module {
  return  module {
    single<RickMortyDatabase> { getDatabase() }  // Inyecta la base de datos de Room en la parte ios
    }
}