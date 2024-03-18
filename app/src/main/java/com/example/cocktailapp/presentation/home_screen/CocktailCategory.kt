package com.example.cocktailapp.presentation.home_screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CocktailCategory(
    category: String,
    icon: Int,
    iconDescription: String,
    homeScreenViewModel: HomeScreenViewModel
) {
    var chosen by rememberSaveable { mutableStateOf(false) }
    chosen = homeScreenViewModel.chosenCategory == category
    val chosenBoxColor by animateColorAsState(
        if (chosen) Color(0xffffdd66) else Color(0xff20202c),
        label = "animated color for box"
    )

    Box(
        modifier = Modifier
            .width(70.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
            .drawBehind { drawRect(chosenBoxColor) }
            .clickable {
                homeScreenViewModel.chosenCategory = category
                if(category == "Shot") {
                    homeScreenViewModel.getAllCocktailsInGlass()
                }
                if(category == "Long") {
                    homeScreenViewModel.getAllCocktailsInFlute()
                }
                if(category == "NonAlc") {
                    homeScreenViewModel.getAllNonalcoholicCocktails()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = iconDescription,
                tint = Color(0xff4d4b65),
                modifier = Modifier
                    .size(32.dp)
            )
            Text(
                text = category,
                fontSize = 15.sp,
                color = Color(0xff4d4b65)
            )
        }
    }
}
