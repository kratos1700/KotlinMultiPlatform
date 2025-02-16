package org.example.rickmotryapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.json.Json
import org.example.rickmotryapp.domain.model.CharacterModel
import org.example.rickmotryapp.ui.detail.CharacterDetailScreen
import org.example.rickmotryapp.ui.home.HomeScreen

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
           HomeScreen(mainNavController)
        }
        composable<CharacterDetail> {
            val characterDetailEncoding: CharacterDetail = it.toRoute<CharacterDetail>() // Recupera el objeto de la ruta
            val characterModel = Json.decodeFromString<CharacterModel>(characterDetailEncoding.characterModel ) // Convertimos el string a un objeto
            CharacterDetailScreen(characterModel)
        }
    }
}