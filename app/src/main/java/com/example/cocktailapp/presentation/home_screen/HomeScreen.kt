package com.example.cocktailapp.presentation.home_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

}