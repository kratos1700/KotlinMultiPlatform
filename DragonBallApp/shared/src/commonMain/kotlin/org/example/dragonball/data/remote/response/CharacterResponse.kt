package org.example.dragonball.data.remote.response

import kotlinx.serialization.Serializable


@Serializable
data class CharacterResponse(
    val id: String,
    val name: String,
    val ki: String,
   val race: String,
    val gender: String,
    val description: String,
    val image :String

)
