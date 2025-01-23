package org.example.rickmotryapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable // sirve para que se pueda serializar y deserializar el objeto de la petición
data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>


    )