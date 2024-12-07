package com.irv205.rickmortygraphql.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.irv205.rickmortygraphql.presentation.component.CharacterDetailScreen
import com.irv205.rickmortygraphql.presentation.component.CharacterListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Navigation.HomeView.route) {

        composable(route = Navigation.HomeView.route) {
            CharacterListScreen(
                onCharacterClick = { characterId ->
                    navController.navigate(Navigation.DetailView.createRoute(characterId))
                }
            )
        }

        composable(
            route = Navigation.DetailView.route,
            arguments = listOf(navArgument("characterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")
            CharacterDetailScreen(characterId = characterId)
        }
    }
}