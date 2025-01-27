package org.example.rickmotryapp.domain

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.CharacterOfTheDayModel

class GetRandomCharacter(val repository: Repository) {

    suspend operator fun invoke(): CharacterModel {

        val characterOfTheDay: CharacterOfTheDayModel? = repository.getCharacterDB()
        val selectedDate = getCurrentDayOfTheYear()

        return if (characterOfTheDay != null && characterOfTheDay.selectedDate == selectedDate) {
            characterOfTheDay.characterModel
        } else {
            val result = getRandomCharacter()
            repository.saveCharacterOfTheDay(
                CharacterOfTheDayModel(
                    characterModel = result,
                    selectedDate
                )
            )
            result
        }


    }

    private suspend fun getRandomCharacter(): CharacterModel {
        val random: Int = (1..826).random() // 826 is the total number of characters in the API
        return repository.getSingleCharacter(random.toString())

    }


    //function to get the current day of the year
    private fun getCurrentDayOfTheYear(): String {
        val instant: Instant = Clock.System.now()  // get the current time
        val localTime =
            instant.toLocalDateTime(TimeZone.currentSystemDefault()) // convert the time to local time
        return "${localTime.dayOfYear}${localTime.year}" // get the day of the year and the year

    }
}