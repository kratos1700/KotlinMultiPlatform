package org.example.rickmotryapp.ui.home.tabs.characters

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.example.rickmotryapp.domain.model.CharacterModel

data class CharactersState (
    val characterOfTheDay : CharacterModel? = null, // estado inicial de la pantalla
    val characters:Flow<PagingData<CharacterModel>> = emptyFlow() // estado inicial de la lista de personajes
)