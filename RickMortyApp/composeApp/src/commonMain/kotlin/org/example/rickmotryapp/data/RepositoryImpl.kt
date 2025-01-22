package org.example.rickmotryapp.data

import org.example.rickmotryapp.data.remote.ApiService
import org.example.rickmotryapp.domain.core.Repository
import org.example.rickmotryapp.domain.model.CharacterModel

class RepositoryImpl( private val apiService: ApiService):Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }

}