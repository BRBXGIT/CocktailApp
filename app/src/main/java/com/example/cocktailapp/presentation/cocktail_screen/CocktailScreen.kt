package com.example.cocktailapp.presentation.cocktail_screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cocktailapp.R
import com.example.cocktailapp.data.db.Cocktail
import com.example.cocktailapp.presentation.bottom_bar.noRippleClickable
import com.example.cocktailapp.presentation.home_screen.HomeScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CocktailScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel
) {

    val cocktail = homeScreenViewModel.currentCocktail.drinks!![0]
    val fontForTitle = FontFamily(Font(R.font.playfairdispla_regular))

    /*Hardcode need to rewrite, but api didn't updates since 2015.
    I don't think something will change) */
    val ingredients = listOf(
        cocktail.strIngredient1, cocktail.strIngredient2,
        cocktail.strIngredient3, cocktail.strIngredient4,
        cocktail.strIngredient5, cocktail.strIngredient6,
        cocktail.strIngredient7, cocktail.strIngredient8,
        cocktail.strIngredient9, cocktail.strIngredient10,
        cocktail.strIngredient11, cocktail.strIngredient12,
        cocktail.strIngredient13
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy((-20).dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
        ) {
            if(cocktail.strDrinkThumb != "") {
                AsyncImage(
                    model = cocktail.strDrinkThumb,
                    contentDescription = "Cocktail photo",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "Go back icon",
                    tint = Color(0xffffdd66),
                    modifier = Modifier
                        .padding(top = 48.dp)
                        .noRippleClickable {
                            navController.navigate("home_screen")
                        }
                )

                val isCocktailInFavorites =
                    Cocktail(cocktail.strDrink) in homeScreenViewModel.getAllFavoriteCocktails()
                        .collectAsState(initial = emptyList()).value

                if(isCocktailInFavorites) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite_filled),
                        contentDescription = "Favorite icon filled",
                        tint = Color(0xffffdd66),
                        modifier = Modifier
                            .padding(top = 48.dp)
                            .noRippleClickable {
                                homeScreenViewModel.deleteCocktailFromFavorites(cocktail.strDrink)
                            }
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite_outlined),
                        contentDescription = "Favorite icon outlined",
                        tint = Color(0xffffdd66),
                        modifier = Modifier
                            .padding(32.dp, top = 48.dp)
                            .noRippleClickable {
                                homeScreenViewModel.upsertNewCocktailToFavorites(cocktail.strDrink)
                            }
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                .background(
                    Brush.linearGradient(
                        listOf(Color(0xff26162f), Color(0xff101b25))
                    )
                )

        ) {
            //Box with title
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = cocktail.strDrink,
                    fontSize = 25.sp,
                    fontFamily = fontForTitle,
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xfff7f7f7)
                )
            }

            //Lazy row with pictures of ingredients
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(ingredients) { ingredient ->
                    if((ingredient != null) && (ingredient != "")) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(120.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xff231f2b)),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .fillMaxHeight(0.9f),
                                contentAlignment = Alignment.Center
                            ) {
                                AsyncImage(
                                    model = "https://www.thecocktaildb.com/images/ingredients/$ingredient.png",
                                    contentDescription = "Ingredient photo",
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = cocktail.strInstructions,
                    fontSize = 20.sp,
                    color = Color(0xfff7f7f7),
                    style = TextStyle.Default.copy(
                        lineBreak = LineBreak.Paragraph
                    )
                )
            }
        }
    }
}