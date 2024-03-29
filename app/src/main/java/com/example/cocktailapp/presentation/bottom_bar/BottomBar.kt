package com.example.cocktailapp.presentation.bottom_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cocktailapp.R

@Composable
fun BottomBar(
    navController: NavHostController
) {
    BottomAppBar(
        containerColor = Color(0xff222225),
        modifier = Modifier
            .height(110.dp)
            .padding(bottom = 28.dp, top = 28.dp, start = 32.dp, end = 32.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home icon",
                tint = Color(0xfff7f7f7),
                modifier = Modifier
                    .size(24.dp)
                    .noRippleClickable {
                        navController.navigate("home_screen")
                    }
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_favorite_outlined),
                contentDescription = "Favorites icon",
                tint = Color(0xfff7f7f7),
                modifier = Modifier
                    .size(24.dp)
                    .noRippleClickable {
                        navController.navigate("favorites_screen")
                    }
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search icon",
                tint = Color(0xfff7f7f7),
                modifier = Modifier
                    .size(24.dp)
                    .noRippleClickable {
                        navController.navigate("search_screen")
                    }
            )
        }
    }
}

//Modifier extension for clicking without ripple
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}