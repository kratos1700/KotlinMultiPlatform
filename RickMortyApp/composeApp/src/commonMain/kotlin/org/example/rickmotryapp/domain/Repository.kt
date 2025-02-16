package org.example.rickmotryapp.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.example.rickmotryapp.data.database.entity.CharacterOfTheDayEntity
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.CharacterOfTheDayModel
import org.example.rickmotryapp.domain.model.EpisodeModel

interface Repository {

    suspend fun getSingleCharacter(id:String): CharacterModel

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>

    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>

    suspend fun getCharacterDB() : CharacterOfTheDayModel?

    suspend fun saveCharacterOfTheDay(characterOfTheDayModel: CharacterOfTheDayModel)

    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>


}