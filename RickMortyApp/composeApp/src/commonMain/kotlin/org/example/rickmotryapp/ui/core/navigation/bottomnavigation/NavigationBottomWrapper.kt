package org.example.rickmotryapp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.rickmotryapp.ui.core.navigation.Routes
import org.example.rickmotryapp.ui.home.tabs.characters.CharacterScreen
import org.example.rickmotryapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
             EpisodesScreen()
        }

        composable(route = Routes.Characters.route) {
            CharacterScreen()
        }
    }
}

