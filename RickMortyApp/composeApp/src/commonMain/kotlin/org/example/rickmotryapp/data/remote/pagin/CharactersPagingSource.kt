package org.example.rickmotryapp.data.remote.pagin


import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.ktor.utils.io.errors.IOException
import org.example.rickmotryapp.data.remote.ApiService
import org.example.rickmotryapp.domain.model.CharacterModel


class CharactersPagingSource(private val apiService: ApiService) :
    PagingSource<Int, CharacterModel>() {
    // Aquí se implementará la lógica para obtener los personajes paginados de la API
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? { // se obtiene la clave de actualización
        return state.anchorPosition // se obtiene la posición del item ancla

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> { // se obtienen los parámetros de carga
        return try {
            val page = params.key ?: 1  // se obtiene la página a cargar
            val response = apiService.getAllCharacter(page) // se obtiene la respuesta de la API
            val characters = response.results   // se obtienen los personajes de la respuesta

            val prev = if(page > 0 ) -1 else null  // se obtiene la página anterior
            val netx = if (response.info.next != null) page + 1 else null // se obtiene la página siguiente

            LoadResult.Page(  // se retorna la página cargada
                data = characters.map { it.toDomain() }, // se retornan los personajes mapeados al modelo de dominio
                prevKey = prev,  // se retorna la página anterior
                nextKey = netx  // se retorna la página siguiente
            )
        } catch (ex: IOException) {
            LoadResult.Error(ex) // se retorna un error en caso de que haya una excepción
        }
    }


}