package org.example.rickmotryapp.domain.model

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.rickmotryapp.data.database.entity.CharacterOfTheDayEntity

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDate: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            isAlive = characterModel.isAlive,
            image = characterModel.image,
            name = characterModel.name,
            selectedDate = selectedDate,
            species = characterModel.species,
            gender = characterModel.gender,
            origin = characterModel.origin,
            episodes =  Json.encodeToString(characterModel.episodes)
        )

    }
}
