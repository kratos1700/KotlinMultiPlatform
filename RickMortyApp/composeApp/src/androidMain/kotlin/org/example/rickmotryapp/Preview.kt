package org.example.rickmotryapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.ui.home.tabs.characters.CharacterOfTheDay

// arxiu per executar previews a Android Studio de KMP

@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {
    CharacterOfTheDay(
        CharacterModel(
            id = 1,
            isAlive = true,
            name = "Rick Sanchez",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            species = "Human",
            gender = "",
            origin = "Earth (C-137)",
            episodes = emptyList()
        ))
}
