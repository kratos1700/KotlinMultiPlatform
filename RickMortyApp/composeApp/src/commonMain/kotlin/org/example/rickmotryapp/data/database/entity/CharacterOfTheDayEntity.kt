package org.example.rickmotryapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.CharacterOfTheDayModel

@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name: String,
    val selectedDate: String

) {
    fun toDomain(): CharacterOfTheDayModel? {
      return  CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                isAlive = isAlive,
                image = image,
                name = name
            ), selectedDate = selectedDate
        )
    }
}
