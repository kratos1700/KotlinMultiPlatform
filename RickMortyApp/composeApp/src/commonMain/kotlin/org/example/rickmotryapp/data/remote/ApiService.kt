package org.example.rickmotryapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.rickmotryapp.data.remote.response.CharacterResponse

class ApiService(private val client: HttpClient) {
    // Aquí se implementarán los métodos para consumir la API
    suspend fun getSingleCharacter(id: String): CharacterResponse {
        // Aquí se implementará la lógica para obtener un personaje por ID
     return   client.get("/api/character/$id").body()
    }

}
