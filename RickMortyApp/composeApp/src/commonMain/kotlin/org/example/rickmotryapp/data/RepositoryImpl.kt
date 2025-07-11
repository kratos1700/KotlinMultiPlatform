package org.example.rickmotryapp.data

import androidx.paging.PagingConfig
import app.cash.paging.Pager
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.example.rickmotryapp.data.database.RickMortyDatabase
import org.example.rickmotryapp.data.remote.ApiService
import org.example.rickmotryapp.data.remote.pagin.CharactersPagingSource
import org.example.rickmotryapp.data.remote.pagin.EpisodesPagingSource
import org.example.rickmotryapp.domain.Repository
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.CharacterOfTheDayModel
import org.example.rickmotryapp.domain.model.EpisodeModel

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val episodesPagingSource: EpisodesPagingSource,
    private val rickMortyDatabase: RickMortyDatabase
) : Repository {

    companion object { // para poder acceder a las propiedades de la clase sin necesidad de instanciarla
        const val PAGE_SIZE = 20 // se define el tamaño de la página
        const val PREFETCH_DISTANCE = 5 // se define la distancia de precarga
    }


    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }

    // Aquí se implementará la lógica para obtener todos los personajes de la API paginados
    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager( // se crea un Pager para obtener los personajes paginados
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE
            ), // se configura el Pager con el tamaño de la página y la distancia de precarga
            pagingSourceFactory = { charactersPagingSource } // se pasa la fuente de datos paginada
        ).flow // se obtiene el flujo de datos paginados

    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = { episodesPagingSource }
        ).flow

    }

    override suspend fun getCharacterDB(): CharacterOfTheDayModel? {
        return rickMortyDatabase.getPreferencesDao().getCharacterOfTheDayDB()?.toDomain()
    }

    override suspend fun saveCharacterOfTheDay(characterOfTheDayModel: CharacterOfTheDayModel) {
        rickMortyDatabase.getPreferencesDao().saveCharacter(characterOfTheDayModel.toEntity())
    }

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> {

        if (episodes.isEmpty()) return emptyList() // si la lista de episodios está vacía, se retorna una lista vacía


        return if (episodes.size > 1) { // si la lista de episodios tiene más de un elemento
            apiService.getEpisodes(episodes.joinToString(",")).map { it.toDomain() } // se obtienen los episodios de la API y se mapean a un objeto de dominio para retornarlos

        } else {
            listOf(apiService.getSingleEpisode(episodes.first()).toDomain()) // si la lista de episodios tiene un solo elemento, se obtiene el episodio de la API y se mapea a un objeto de dominio para retornarlo
        }
    }

}