package org.example.rickmotryapp.ui.detail

import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.domain.model.EpisodeModel

data class CharacterDetailState(
    val characterModel: CharacterModel,
    val episodes: List<EpisodeModel>? = null


)
