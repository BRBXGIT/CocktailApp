package com.example.cocktailapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cocktailapp.R

@Composable
fun HomeScreen() {

    val fontForLabel = FontFamily(Font(R.font.playfairdispla_regular))
    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

    //Main column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(Color(0xff26162f), Color(0xff101b25))
                )
            )
    ) {
        //Box with user icon
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.12f)
        ) {

        }

        //Box with label
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Choose\n",
                fontFamily = fontForLabel,
                fontSize = 45.sp,
                color = Color(0xfff7f7f7),
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                modifier = Modifier.padding(bottom = 24.dp)
            )
            Text(
                text = "your drink",
                fontFamily = fontForLabel,
                fontSize = 45.sp,
                color = Color(0xfff7f7f7),
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }

        //Row with lazyColumn and column with categories
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.3f)
            ) {
                //Categories
                CocktailCategory(category = "Shot", icon = R.drawable.ic_glass, iconDescription = "Glass cocktails", homeScreenViewModel = homeScreenViewModel)
                CocktailCategory(category = "Long", icon = R.drawable.ic_flute, iconDescription = "Flute cocktails", homeScreenViewModel = homeScreenViewModel)
                CocktailCategory(category = "NonAlc", icon = R.drawable.ic_sad, iconDescription = "Nonalcohol cocktails", homeScreenViewModel = homeScreenViewModel)
            }

            if(homeScreenViewModel.chosenCategory != "") {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 16.dp)
                ) {
                    items(homeScreenViewModel.chosenCocktails.drinks) { drink ->
                        CocktailCard(
                            title = drink.strDrink,
                            homeScreenViewModel = homeScreenViewModel,
                            isInFavorite = false,
                            picture = drink.strDrinkThumb
                        )
                    }
                }
            }
        }
    }
}