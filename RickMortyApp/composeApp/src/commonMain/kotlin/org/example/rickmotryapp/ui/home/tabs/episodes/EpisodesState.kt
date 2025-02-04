package org.example.rickmotryapp.ui.home.tabs.episodes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.example.rickmotryapp.domain.model.EpisodeModel

data class EpisodesState(
    val characters : Flow<PagingData<EpisodeModel>> = emptyFlow(),
    val playVideo : String = ""
)
