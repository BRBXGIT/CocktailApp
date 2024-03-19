package com.example.cocktailapp.presentation.favorites_scrren

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.cocktailapp.presentation.bottom_bar.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScreen(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(text = "Favorites screen")
        }
    }
}