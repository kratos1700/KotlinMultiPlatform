package org.example.dragonball.domain

import org.example.dragonball.domain.model.CharacterDetailModel
import org.example.dragonball.domain.model.CharacterModel

interface Repository {

    suspend fun getCharacters():List<CharacterModel>
    suspend fun getSingleCharacter(id:Int): CharacterDetailModel?
}