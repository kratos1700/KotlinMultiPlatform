package org.example.rickmotryapp.ui.core.navigation

sealed class Routes (val route:String) {
    data object Home: Routes("home")

}