package org.example.rickmotryapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.rickmotryapp.data.remote.ApiService
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single { // single es para que solo se cree una vez y se reutilice en toda la app
        HttpClient {  // configuracion del cliente http
            install(ContentNegotiation) { // instalacion de la configuracion de la negociacion de contenido
                json(
                    json = Json { ignoreUnknownKeys = true },
                    contentType = ContentType.Any
                )  // sirve para que ignore las propiedades que no estan en el modelo de datos y no tire error
            }

            install(DefaultRequest) { // instalacion de la configuracion de la peticion por defecto
                url {
                    protocol = URLProtocol.HTTPS // protocolo de la url
                    host = "rickandmortyapi.com" // host de la url
                  //  parameters.append("key", "value") // parametros de la url
                }
            }
        }
    }

    factoryOf(::ApiService) // factoryOf es para que se cree una nueva instancia cada vez que se solicite
}