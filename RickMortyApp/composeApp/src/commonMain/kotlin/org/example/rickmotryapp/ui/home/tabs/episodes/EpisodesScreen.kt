package org.example.rickmotryapp.ui.home.tabs.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import org.example.rickmotryapp.domain.model.EpisodeModel
import org.example.rickmotryapp.domain.model.SeasonEpisodes
import org.example.rickmotryapp.ui.core.components.PagingLoadingState
import org.example.rickmotryapp.ui.core.components.PagingType
import org.example.rickmotryapp.ui.core.components.PagingWrapper
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.season1
import rickmortyapp.composeapp.generated.resources.season2
import rickmortyapp.composeapp.generated.resources.season3
import rickmortyapp.composeapp.generated.resources.season4
import rickmortyapp.composeapp.generated.resources.season5
import rickmortyapp.composeapp.generated.resources.season6
import rickmortyapp.composeapp.generated.resources.season7

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EpisodesScreen(modifier: Modifier = Modifier) {

    val episodesViewModel = koinViewModel<EpisodesViewModel>()

    val state by episodesViewModel.state.collectAsState()
    val episodes = state.characters.collectAsLazyPagingItems()

    Box(Modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoadingState()
            },
            emptyView = {

            },
            itemView = {
                EpisodesItemList(it) // it es el episodio gestionado por PagingWrapper generico
            }

        )
    }
}

@Composable
fun EpisodesItemList(episode: EpisodeModel) {

    Column(modifier = Modifier.width(120.dp).padding(horizontal = 8.dp).clickable { }) {
        Image(
            modifier = Modifier.height(200.dp).fillMaxWidth(),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            painter = painterResource(getSeasonImage(episode.season))
        )
    }
}

fun getSeasonImage(seasonEpisode: SeasonEpisodes): DrawableResource {
    return when (seasonEpisode) {
        SeasonEpisodes.SEASON_1 -> Res.drawable.season1
        SeasonEpisodes.SEASON_2 -> Res.drawable.season2
        SeasonEpisodes.SEASON_3 -> Res.drawable.season3
        SeasonEpisodes.SEASON_4 -> Res.drawable.season4
        SeasonEpisodes.SEASON_5 -> Res.drawable.season5
        SeasonEpisodes.SEASON_6 -> Res.drawable.season6
        SeasonEpisodes.SEASON_7 -> Res.drawable.season7
        SeasonEpisodes.UNKNOWN -> Res.drawable.season1
    }
}