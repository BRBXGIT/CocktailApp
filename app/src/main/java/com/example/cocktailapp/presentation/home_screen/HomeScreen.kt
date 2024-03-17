package com.example.cocktailapp.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

}