package org.example.rickmotryapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class EpisodesWraaperResponse(
    val info:InfoResponse,
    val results:List<EpisodeResponse>
)
