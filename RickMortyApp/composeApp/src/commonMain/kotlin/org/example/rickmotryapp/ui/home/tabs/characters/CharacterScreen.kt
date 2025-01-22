package org.example.rickmotryapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.ui.core.ex.vertical
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharacterScreen(

) {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState() //obtenemos el estado del viewmodel como un State

    Column(Modifier.fillMaxSize()) {

        CharacterOfTheDay(state.characterOfTheDay) //mostramos el personaje del dia en la pantalla
    }

}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null) {

    Card(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        shape = RoundedCornerShape(12)

    ) {
        if (characterModel == null) {
            Box(contentAlignment = Alignment.Center) {

                CircularProgressIndicator()
            }
        } else {
            Box(contentAlignment = Alignment.BottomStart) {

            AsyncImage(
                model = characterModel.image,
                contentDescription = "Character Of the day",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
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
                    color = Color.White,
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