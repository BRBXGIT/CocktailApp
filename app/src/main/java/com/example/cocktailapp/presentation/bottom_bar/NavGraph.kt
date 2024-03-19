package com.example.cocktailapp.presentation.bottom_bar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cocktailapp.presentation.cocktail_screen.CocktailScreen
import com.example.cocktailapp.presentation.favorites_scrren.FavoritesScreen
import com.example.cocktailapp.presentation.home_screen.HomeScreen
import com.example.cocktailapp.presentation.home_screen.HomeScreenViewModel
import com.example.cocktailapp.presentation.search_screen.SearchScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable(route = "home_screen") {
            HomeScreen(
                navController = navController,
                homeScreenViewModel = homeScreenViewModel
            )
        }

        composable(route = "favorites_screen") {
            FavoritesScreen(
                navController = navController,
                homeScreenViewModel = homeScreenViewModel
            )
        }

        composable(route = "search_screen") {
            SearchScreen(
                navController = navController,
                homeScreenViewModel = homeScreenViewModel
            )
        }

        composable(route = "cocktail_screen") {
            CocktailScreen(
                navController = navController,
                homeScreenViewModel = homeScreenViewModel
            )
        }
    }
}