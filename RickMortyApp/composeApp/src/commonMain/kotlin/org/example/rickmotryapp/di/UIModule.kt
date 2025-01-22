package org.example.rickmotryapp.di

import org.example.rickmotryapp.ui.home.tabs.characters.CharactersViewModel
import org.example.rickmotryapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::EpisodesViewModel)   // inyectamos el viewmodel de EpisodesViewModel
    viewModelOf(::CharactersViewModel) // inyectamos el viewmodel de CharactersViewModel

}