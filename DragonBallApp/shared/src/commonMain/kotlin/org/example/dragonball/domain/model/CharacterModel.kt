package org.example.dragonball.domain.model

import kotlinx.serialization.Serializable


data class CharacterModel(
    val id: Int,
    val name: String,
    val ki: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,

)
