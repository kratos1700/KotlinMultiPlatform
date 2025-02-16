package org.example.rickmotryapp.ui.home.tabs.episodes

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import org.example.rickmotryapp.domain.model.EpisodeModel
import org.example.rickmotryapp.domain.model.SeasonEpisodes
import org.example.rickmotryapp.ui.core.BackgroundPrimaryColor
import org.example.rickmotryapp.ui.core.BackgroundSecondaryColor
import org.example.rickmotryapp.ui.core.BackgroundTertiariColor
import org.example.rickmotryapp.ui.core.DefaultTextColor
import org.example.rickmotryapp.ui.core.components.PagingLoadingState
import org.example.rickmotryapp.ui.core.components.PagingType
import org.example.rickmotryapp.ui.core.components.PagingWrapper
import org.example.rickmotryapp.ui.core.components.VideoPlayer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.placeholder
import rickmortyapp.composeapp.generated.resources.portal
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

    Column(Modifier.fillMaxSize().background(BackgroundPrimaryColor)) {
        Spacer(Modifier.height(16.dp))
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoadingState()
            },
            emptyView = {

            },
            itemView = {
                EpisodesItemList(it) {
                    episodesViewModel.playVideo(it)
                } // it es el episodio gestionado por PagingWrapper generico
            }

        )

        EpisodePlayer(state.playVideo) {
            episodesViewModel.closeVideo()
        }

    }
}

@Composable
fun EpisodesItemList(episode: EpisodeModel, onEpisodeSelected: (String) -> Unit = {}) {

    Column(
        modifier = Modifier.width(120.dp).padding(horizontal = 8.dp)
            .clickable { onEpisodeSelected(episode.videoUrl) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(180.dp).fillMaxWidth(),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            painter = painterResource(getSeasonImage(episode.season))
        )
        Text(episode.episode, color = DefaultTextColor, fontWeight = FontWeight.Bold)
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


@Composable
fun EpisodePlayer(playVideo: String, onCloseVideo: () -> Unit) {
    AnimatedContent(playVideo.isNotBlank()) { condition ->
        if (condition) {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth().height(250.dp).padding(16.dp)
                    .border(3.dp, Color.Green, CardDefaults.elevatedShape)
            ) {
                Box(modifier = Modifier.background(color = Color.Black)) {
                    Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {

                        VideoPlayer(Modifier.fillMaxWidth().height(200.dp), playVideo)
                    }
                    Row {
                        Spacer(Modifier.weight(1f))
                        Image(
                            painter = painterResource(Res.drawable.portal),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp).size(40.dp)
                                .clickable { onCloseVideo() }
                        )
                    }
                }
            }

        } else {

            ElevatedCard(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                colors = CardDefaults.elevatedCardColors().copy(containerColor = BackgroundSecondaryColor)


            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(
                        painter = painterResource(Res.drawable.placeholder),
                        contentDescription = null,
                        // modifier = Modifier.fillMaxSize()
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Aw, jeez, you gotta click the video, guys! I mean, it might be important or something!",
                        fontStyle = FontStyle.Italic,
                        color = DefaultTextColor,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }


    }

}