package org.example.dragonball.data

import org.example.dragonball.data.remote.ApiService
import org.example.dragonball.domain.Repository
import org.example.dragonball.domain.model.CharacterDetailModel
import org.example.dragonball.domain.model.CharacterModel

class RepositoryImp(private val apiService: ApiService) : Repository {
    override suspend fun getCharacters(): List<CharacterModel> {
        return apiService.getAllCharacters().items.map {
            it.toDomain()
        }
    }

    override suspend fun getSingleCharacter(id: Int): CharacterDetailModel? {
        return  apiService.getDetailCharacter(id)?.toDetailDomain()
    }


}