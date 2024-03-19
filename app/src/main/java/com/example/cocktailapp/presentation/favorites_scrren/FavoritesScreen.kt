package com.example.cocktailapp.presentation.favorites_scrren

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cocktailapp.R
import com.example.cocktailapp.presentation.bottom_bar.BottomBar
import com.example.cocktailapp.presentation.home_screen.HomeScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel
) {

    val fontForLabel = FontFamily(Font(R.font.playfairdispla_regular))

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf(Color(0xff26162f), Color(0xff101b25))
                    )
                )
        ) {

            //Label
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Favorites",
                    fontFamily = fontForLabel,
                    fontSize = 45.sp,
                    color = Color(0xfff7f7f7),
                )
            }
        }
    }
}