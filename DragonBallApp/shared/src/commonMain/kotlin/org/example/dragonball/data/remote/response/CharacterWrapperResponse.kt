package org.example.dragonball.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class CharacterWrapperResponse(
    val items:List<CharacterResponse>
)