package org.example.rickmotryapp.di

import org.example.rickmotryapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Koin modules for the app para inyectar dependencias en la parte de IOS y ANDROID
 */
actual fun platformModule(): Module {
   return module {
      single { getDatabase() }
   }
}