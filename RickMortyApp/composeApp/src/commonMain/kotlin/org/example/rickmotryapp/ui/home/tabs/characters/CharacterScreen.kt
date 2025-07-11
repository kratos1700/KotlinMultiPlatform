package org.example.rickmotryapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.ui.core.BackgroundPrimaryColor
import org.example.rickmotryapp.ui.core.DefaultTextColor
import org.example.rickmotryapp.ui.core.Green
import org.example.rickmotryapp.ui.core.components.PagingLoadingState

import org.example.rickmotryapp.ui.core.components.PagingType
import org.example.rickmotryapp.ui.core.components.PagingWrapper
import org.example.rickmotryapp.ui.core.ex.vertical
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.rickface

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharacterScreen(navigateToDetail :(CharacterModel) -> Unit) {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState() //obtenemos el estado del viewmodel como un State
    val characters =
        state.characters.collectAsLazyPagingItems() //obtenemos los personajes como LazyPagingItems para poder paginar la lista

    CharactersGridList(characters, state, navigateToDetail) //mostramos la lista de personajes en la pantalla


}

    @Composable
    fun CharactersGridList(
        characters: LazyPagingItems<CharacterModel>,
        state: CharactersState,
        navigateToDetail: (CharacterModel) -> Unit,
    ) {

        PagingWrapper(pagingType = PagingType.VERTICAL_GRID,
            pagingItems = characters,
            initialView = { PagingLoadingState() },
            itemView = { CharacterItemList(it) { characterModel -> navigateToDetail(characterModel) } },
            header = {
                Column {
                    Text(
                        "Characters",
                        color = DefaultTextColor,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.height(6.dp))
                    CharacterOfTheDay(state.characterOfTheDay)
                }
            })
    }
@Composable
fun CharacterItemList(character: CharacterModel, onItemSelected: (CharacterModel) -> Unit = {}) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(24))
            .border(
                2.dp, Color.Green,
                shape = RoundedCornerShape(0, 24, 0, 24)
            ) // agregamos un borde al item del personaje con un color verde y una forma redondeada en las esquinas superiores e inferiores
            .fillMaxWidth().height(150.dp)
            .clickable { onItemSelected(character) },
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(Res.drawable.rickface)
        )
        Box(
            modifier = Modifier.fillMaxWidth().height(60.dp).background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(alpha = 0f),
                        Color.Black.copy(alpha = 0.6f),
                        Color.Black.copy(alpha = 1f)
                    )
                )
            ), contentAlignment = Alignment.Center
        ) {
            Text(
                text = character.name,
                color = Color.White,
                fontSize = 18.sp,
            )
        }
    }

}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null) {

    Card(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        shape = RoundedCornerShape(12)

    ) {
        if (characterModel == null) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

                CircularProgressIndicator(color = Green)
            }
        } else {
            Box(contentAlignment = Alignment.BottomStart) {

                AsyncImage(
                    model = characterModel.image,
                    contentDescription = "Character Of the day",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),

                    )

                Box(
                    Modifier.fillMaxSize()
                        .background(  //creamos un degradado para oscurecer la imagen
                            Brush.horizontalGradient(
                                // degradado horizontal
                                0f to Color.Black.copy(alpha = 0.9f),
                                0.4f to Color.Black.copy(alpha = 0f),
                                1f to Color.Black.copy(alpha = 0f),
                            )
                        )
                )
                Text(
                    characterModel.name,
                    fontSize = 40.sp,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = DefaultTextColor,
                    overflow = TextOverflow.Ellipsis, //si el texto es muy largo, se corta y se muestra puntos suspensivos
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .fillMaxHeight()
                        .vertical()
                        .rotate(-90f)
                )
            }
        }

    }

}
