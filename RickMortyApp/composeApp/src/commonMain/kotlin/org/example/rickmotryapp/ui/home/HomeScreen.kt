package org.example.rickmotryapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.example.rickmotryapp.ui.core.navigation.bottomnavigation.BottomBarItem
import org.example.rickmotryapp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper

@Composable
fun HomeScreen () {
    val items = listOf(BottomBarItem.Episodes(), BottomBarItem.Characters())
    val navController = rememberNavController()

   Scaffold(bottomBar = {
        BottomNavigation(items = items, navController) }){

       Box {
           NavigationBottomWrapper(navController = navController)
       }

   }

}


/*
 * Bottom Navigation
 * items: List of BottomBarItem es un listado de los items que se mostrarán en la barra de navegación
 * NavigationBar: es el contenedor de los items de la barra de navegación
 * currentDestination: es el destino actual de la navegación en la aplicación y destinaion es el destino de la navegación
 * .hierarchy: es una lista de los destinos de la navegación
 */
@Composable
fun BottomNavigation(items: List<BottomBarItem>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()  // acedemos a la pila de navegación
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = { Text(item.title) },
                onClick={
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { route -> // obtiene el destino de inicio de la gráfica de navegación
                            popUpTo(route) {  // elimina todos los destinos de la pila de navegación hasta el destino de inicio
                                saveState = true // guarda el estado del destino
                            }
                        }
                        launchSingleTop = true // si el destino ya está en la pila de navegación, se mantiene en la parte superior
                        restoreState = true // restaura el estado del destino
                    }
                },
               selected= currentDestination?.hierarchy?.any { it.route == item.route } == true  // si el destino actual es igual al destino del item seleccionado
            )
        }
    }
    
}