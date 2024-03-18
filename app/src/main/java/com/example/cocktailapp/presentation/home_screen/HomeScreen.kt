package com.example.cocktailapp.presentation.home_screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

    val cocktail = homeScreenViewModel.nonAlcoholicCocktails

    homeScreenViewModel.getAllNonalcoholicCocktails()

    LazyColumn {
        items(cocktail.drinks) { c ->
            Text(text = c.idDrink)
        }
    }
}