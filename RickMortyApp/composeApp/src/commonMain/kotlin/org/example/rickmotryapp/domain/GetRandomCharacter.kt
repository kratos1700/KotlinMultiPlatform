package org.example.rickmotryapp.domain

import org.example.rickmotryapp.domain.core.Repository
import org.example.rickmotryapp.domain.model.CharacterModel

class GetRandomCharacter (val repository: Repository) {

    suspend operator fun invoke() : CharacterModel{
        val random:Int = (1..826).random() // 826 is the total number of characters in the API
     return repository.getSingleCharacter(random.toString())
    }
}