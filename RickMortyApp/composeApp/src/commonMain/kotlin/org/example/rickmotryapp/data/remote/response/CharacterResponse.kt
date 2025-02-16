package org.example.rickmotryapp.data.remote.response

import androidx.compose.animation.core.SnapSpec
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.rickmotryapp.domain.model.CharacterModel


@Serializable // sirve para que se pueda serializar y deserializar el objeto de la petición
data class CharacterResponse(
    @SerialName("id") val id: Int,  // SerialName es para que coincida con el nombre de la propiedad en la respuesta de la API
    val name: String,
    val status: String,
    val image: String,
    val species: String,
    val gender: String,
    val origin: OriginResponse,
    val episode:List<String>
) {
    fun toDomain(): CharacterModel {  // convierte el objeto de la respuesta de la API a un objeto de dominio

        return CharacterModel(
            id = id,
            name = name,
            image = image,
            isAlive = status.lowercase() == "alive",
            species = species,
            gender = gender,
            origin = origin.name,
            episodes = episode.map{ it.substringAfterLast("/") }  // extrae el id del episodio de la URL
        )

    }
}