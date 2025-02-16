package org.example.rickmotryapp.data.remote.response

import kotlinx.serialization.Serializable
import org.example.rickmotryapp.domain.model.EpisodeModel
import org.example.rickmotryapp.domain.model.SeasonEpisodes

@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val episode: String,
    val characters: List<String>,


    ) {
    fun toDomain(): EpisodeModel {
        val season = getSeasonFromEpisodeCode(episode)
        return EpisodeModel(
            id = id,
            name = name,
            episode = episode,
            characters = characters.map { url -> url.substringAfterLast("/") },
            season = season,
            videoUrl = getVideoURLFromSeason(season)
        )
    }

    private fun getVideoURLFromSeason(season: SeasonEpisodes): String {
        return when (season) {
            SeasonEpisodes.SEASON_1 -> "https://www.youtube.com/watch?v=8BEzj2kRjO8&ab_channel=RottenTomatoesTV"
            SeasonEpisodes.SEASON_2 -> "https://www.youtube.com/watch?v=SXwf_9xJu5c&ab_channel=Yusuto"
            SeasonEpisodes.SEASON_3 -> "https://www.youtube.com/watch?v=Bmg2vXOQ3kM&ab_channel=SeriesTrailerMP"
            SeasonEpisodes.SEASON_4 -> "https://www.youtube.com/watch?v=bLI2-v264No&ab_channel=RottenTomatoesTV"
            SeasonEpisodes.SEASON_5 -> "https://www.youtube.com/watch?v=yC1UxW8vcDo&ab_channel=RottenTomatoesTV"
            SeasonEpisodes.SEASON_6 -> "https://www.youtube.com/watch?v=jerFRSQW9g8&ab_channel=RottenTomatoesTV"
            SeasonEpisodes.SEASON_7 -> "https://www.youtube.com/watch?v=PkZtVBNkmso&ab_channel=RottenTomatoesTV"
            SeasonEpisodes.UNKNOWN -> "https://www.youtube.com/watch?v=E8cXKMR9a1Q"
        }

    }

    private fun getSeasonFromEpisodeCode(episode: String): SeasonEpisodes {
        return when {
            episode.startsWith("S01") -> SeasonEpisodes.SEASON_1
            episode.startsWith("S02") -> SeasonEpisodes.SEASON_2
            episode.startsWith("S03") -> SeasonEpisodes.SEASON_3
            episode.startsWith("S04") -> SeasonEpisodes.SEASON_4
            episode.startsWith("S05") -> SeasonEpisodes.SEASON_5
            episode.startsWith("S06") -> SeasonEpisodes.SEASON_6
            episode.startsWith("S07") -> SeasonEpisodes.SEASON_7
            else -> SeasonEpisodes.UNKNOWN

        }
    }
}
