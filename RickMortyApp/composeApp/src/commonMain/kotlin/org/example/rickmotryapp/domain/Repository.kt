package org.example.rickmotryapp.domain.core

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.example.rickmotryapp.domain.model.CharacterModel

interface Repository {

    suspend fun getSingleCharacter(id:String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}