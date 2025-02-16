package org.example.rickmotryapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.json.Json
import org.example.rickmotryapp.data.remote.response.OriginResponse
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.CharacterOfTheDayModel

@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name: String,
    val selectedDate: String,
    val species: String,
    val gender: String,
    val origin: String,
    val episodes:String

) {
    fun toDomain(): CharacterOfTheDayModel? {
      return  CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                isAlive = isAlive,
                image = image,
                name = name,
                species = species,
                gender = gender,
                origin = origin,
                episodes = Json.decodeFromString<List<String>>(episodes)  //decodifica la lista de episodios que está en formato JSON a una lista de Strings

            ), selectedDate = selectedDate
        )
    }
}
