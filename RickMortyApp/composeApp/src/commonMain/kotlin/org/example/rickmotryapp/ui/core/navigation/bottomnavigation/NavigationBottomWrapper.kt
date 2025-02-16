package org.example.rickmotryapp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.rickmotryapp.ui.core.navigation.CharacterDetail
import org.example.rickmotryapp.ui.core.navigation.Routes
import org.example.rickmotryapp.ui.home.tabs.characters.CharacterScreen
import org.example.rickmotryapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController: NavHostController, mainNavController:NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
             EpisodesScreen()
        }

        composable(route = Routes.Characters.route) {
            CharacterScreen(
               navigateToDetail = {
                   val encode :String = Json.encodeToString(it)  // Convertimos el objeto a un string
                   mainNavController.navigate(CharacterDetail(encode)) // Navegamos a la pantalla de detalle del personaje con el objeto convertido a string
               }
            )
        }
    }
}

