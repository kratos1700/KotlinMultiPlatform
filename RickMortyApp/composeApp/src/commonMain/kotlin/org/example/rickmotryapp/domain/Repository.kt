package org.example.rickmotryapp.domain.core

import org.example.rickmotryapp.domain.model.CharacterModel

interface Repository {

    suspend fun getSingleCharacter(id:String): CharacterModel
}