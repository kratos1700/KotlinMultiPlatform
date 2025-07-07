package org.example.dragonball.domain.model

data class CharacterDetailModel(

    val characterModel: CharacterModel,
    val originPlanet: OriginPlanetModel,
    val transformations: List<TransformationModel>


)
