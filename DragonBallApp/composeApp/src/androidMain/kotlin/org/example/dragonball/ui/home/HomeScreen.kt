package org.example.dragonball.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.example.dragonball.R
import org.example.dragonball.domain.model.CharacterModel
import org.example.dragonball.resources.BackgroundPrimary
import org.example.dragonball.resources.Orange
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {

    val homeViewModel: HomeViewModel = koinViewModel()


    val characters by homeViewModel.characters.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimary.copy(alpha = 0.8f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Goku Edition", modifier = Modifier.padding(32.dp), fontWeight = FontWeight.Bold, fontSize = 32.sp, color = Color.White)
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp)) {


            items(characters) { character ->
                CharacterItem(character){

                }
            }

        }
        Text(text = characters.toString())
    }

}

@Composable
fun CharacterItem(character: CharacterModel, onItemClick: (CharacterModel) -> Unit = {}) {

    Box(
        Modifier
            .padding(16.dp)
            .height(250.dp)
            .clickable { onItemClick(character) }
        , contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1f))
            Card(Modifier.fillMaxWidth(), border = BorderStroke(4.dp, Orange)) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = character.name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Text(text = character.race, fontStyle = FontStyle.Italic, fontSize = 18.sp)

                }
            }

        }
        DragonBallShape()
        AsyncImage(model = character.image, contentDescription = "image", modifier = Modifier.size(180.dp))
    }
}

@Composable
fun DragonBallShape() {
    Box(
        modifier = Modifier
            .size(180.dp)
            .clip(CircleShape)
            .background(Orange)
            .border(
                BorderStroke(
                    6.dp,
                    Brush.horizontalGradient(
                        listOf(
                            Color.White.copy(alpha = 0.4f),
                            Orange,
                            Orange,

                            )
                    )
                ),
                CircleShape
            ), contentAlignment = Alignment.Center

    ) {
        Row {

            Column {
                DragonBallStar()
                DragonBallStar()

            }

            Column {
                DragonBallStar()
                DragonBallStar()

            }
        }


    }
}


@Composable
fun DragonBallStar() {
    Icon(
        modifier = Modifier
            .padding(10.dp)
            .size(24.dp),
        painter = androidx.compose.ui.res.painterResource(R.drawable.ic_star),
        contentDescription = "Star Icon",
        tint = Color.Red
    )
}