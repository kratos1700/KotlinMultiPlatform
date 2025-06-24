package org.example.dragonball.di

import org.example.dragonball.ui.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val uiModule = module {
   factoryOf(::HomeViewModel)

   // factoryOf(::DetailViewModel)
}