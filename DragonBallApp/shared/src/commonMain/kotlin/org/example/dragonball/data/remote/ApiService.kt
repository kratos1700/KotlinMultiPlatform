package org.example.dragonball.data.remote

import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.dragonball.data.remote.response.CharacterResponse
import org.example.dragonball.data.remote.response.CharacterWrapperResponse

class ApiService(private val client: HttpClient) {

    suspend fun getAllCharacters():CharacterWrapperResponse {


        return try {

            client.get("/api/characters") {
                parameter("limit", 60) // Optional: specify the limit of characters to fetch
            }.body()
        } catch (err: Exception) {
            // Handle the error appropriately, e.g., log it or rethrow it
            Logger.e { "Error Api Services: ${err.message}" }
           return CharacterWrapperResponse(emptyList())
        }

    }

    suspend fun getDetailCharacter(id:Int):CharacterResponse?{
        return try {
            client.get("/api/characters/$id").body()
        }catch (e:Exception){
            Logger.e{ "Error API SERVICE -> ${e.message}"}
            return null
        }
    }

}