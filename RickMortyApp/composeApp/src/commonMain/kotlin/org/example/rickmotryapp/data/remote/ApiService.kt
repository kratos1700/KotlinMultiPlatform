package org.example.rickmotryapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.rickmotryapp.data.remote.response.CharacterResponse
import org.example.rickmotryapp.data.remote.response.CharactersWrapperResponse
import org.example.rickmotryapp.data.remote.response.EpisodeResponse
import org.example.rickmotryapp.data.remote.response.EpisodesWraaperResponse

class ApiService(private val client: HttpClient) {
    // Aquí se implementarán los métodos para consumir la API
    suspend fun getSingleCharacter(id: String): CharacterResponse {
        // Aquí se implementará la lógica para obtener un personaje por ID
        return client.get("/api/character/$id").body()
    }

    // Aquí se implementará la lógica para obtener todos los personajes de la API paginados
    suspend fun getAllCharacter(page: Int): CharactersWrapperResponse {

        return client.get("/api/character/") {  // Aquí se implementará la lógica para obtener todos los personajes de la API paginados
            parameter(
                "page",
                page
            ) // el parameter es para pasar el número de página que se quiere obtener
        }.body()

    }

    suspend fun getAllEpisodes(page: Int): EpisodesWraaperResponse {
        return client.get("/api/episode/") {
            parameter("page", page)
        }.body()
    }

    suspend fun getEpisodes(episodes: String): List<EpisodeResponse> {
        return client.get("/api/episode/$episodes").body()


    }

    suspend fun getSingleEpisode(episodeId: String): EpisodeResponse {
        return client.get("/api/episode/$episodeId").body()

    }

}
