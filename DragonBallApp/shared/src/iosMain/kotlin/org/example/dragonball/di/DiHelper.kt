package org.example.dragonball.di

import org.example.dragonball.domain.Repository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/*
    Esta clase es un helper para acceder al repositorio desde el código de iOS.
 */
class DiHelper: KoinComponent {

    val repository: Repository by inject()

}