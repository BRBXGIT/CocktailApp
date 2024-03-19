package com.example.cocktailapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cocktailapp.R
import com.example.cocktailapp.data.db.Cocktail
import com.example.cocktailapp.presentation.bottom_bar.noRippleClickable

@Composable
fun CocktailCard(
    title: String,
    homeScreenViewModel: HomeScreenViewModel,
    picture: Any?,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(bottom = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf(Color(0xff26162f), Color(0xff101b25))
                    )
                ),
            contentAlignment = Alignment.TopStart
        ) {
            if(picture != null) {
                AsyncImage(
                    model = picture,
                    contentDescription = "Cocktail photo",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    color = Color(0xffffdd66),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(16.dp)
                )

                val isCocktailInFavorites =
                    Cocktail(title) in homeScreenViewModel.getAllFavoriteCocktails()
                        .collectAsState(initial = emptyList()).value

                if(isCocktailInFavorites) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite_filled),
                        contentDescription = "Favorite icon filled",
                        tint = Color(0xffffdd66),
                        modifier = Modifier
                            .padding(16.dp)
                            .noRippleClickable {
                                homeScreenViewModel.deleteCocktailFromFavorites(title)
                            }
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite_outlined),
                        contentDescription = "Favorite icon outlined",
                        tint = Color(0xffffdd66),
                        modifier = Modifier
                            .padding(16.dp)
                            .noRippleClickable {
                                homeScreenViewModel.upsertNewCocktailToFavorites(title)
                            }
                    )
                }
            }
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