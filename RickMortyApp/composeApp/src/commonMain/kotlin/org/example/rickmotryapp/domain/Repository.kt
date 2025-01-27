package org.example.rickmotryapp.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.example.rickmotryapp.data.database.entity.CharacterOfTheDayEntity
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.CharacterOfTheDayModel

interface Repository {

    suspend fun getSingleCharacter(id:String): CharacterModel

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>

    suspend fun getCharacterDB() : CharacterOfTheDayModel?

    suspend fun saveCharacterOfTheDay(characterOfTheDayModel: CharacterOfTheDayModel)



}