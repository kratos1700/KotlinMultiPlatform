package org.example.dragonball.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.dragonball.ui.detail.DetailScreen
import org.example.dragonball.ui.home.HomeScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navigateToDetail = {
                navController.navigate(Detail(id = it))
            })
        }

        composable<Detail> {navBackStackEntry ->
            val detail :Detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(detail.id, navigateBack = {
                navController.popBackStack()
            })
        }
    }
}