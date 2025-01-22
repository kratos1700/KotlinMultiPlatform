package org.example.rickmotryapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.rickmotryapp.domain.model.CharacterModel


@Serializable // sirve para que se pueda serializar y deserializar el objeto de la petición
data class CharacterResponse(
   @SerialName("id") val id: Int,  // SerialName es para que coincida con el nombre de la propiedad en la respuesta de la API
    val status: String,
    val image: String
) {
    fun toDomain(): CharacterModel {  // convierte el objeto de la respuesta de la API a un objeto de dominio

        return CharacterModel(
            id = id,
            image = image,
            isAlive = status.lowercase() == "alive"
        )

    }
}