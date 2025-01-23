package org.example.rickmotryapp.data

import androidx.paging.PagingConfig
import app.cash.paging.Pager
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.example.rickmotryapp.data.remote.ApiService
import org.example.rickmotryapp.data.remote.pagin.CharactersPagingSource
import org.example.rickmotryapp.domain.core.Repository
import org.example.rickmotryapp.domain.model.CharacterModel

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource
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
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PREFETCH_DISTANCE), // se configura el Pager con el tamaño de la página y la distancia de precarga
            pagingSourceFactory = { charactersPagingSource } // se pasa la fuente de datos paginada
        ).flow // se obtiene el flujo de datos paginados

    }

}