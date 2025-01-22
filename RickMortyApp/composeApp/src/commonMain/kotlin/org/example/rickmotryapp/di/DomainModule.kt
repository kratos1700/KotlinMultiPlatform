package org.example.rickmotryapp.di

import org.example.rickmotryapp.domain.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacter)  // This is the same as factory { GetRandomCharacter(get()) }

}