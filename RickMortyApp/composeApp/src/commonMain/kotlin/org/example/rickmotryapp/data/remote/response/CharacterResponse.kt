package org.example.rickmotryapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable // sirve para que se pueda serializar y deserializar el objeto de la petición
data class CharacterResponse(
   @SerialName("id") val id: String,  // SerialName es para que coincida con el nombre de la propiedad en la respuesta de la API
    val status: String,
    val image: String
)