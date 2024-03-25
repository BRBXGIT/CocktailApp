package com.example.cocktailapp.presentation.search_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cocktailapp.data.remote.Drink
import com.example.cocktailapp.presentation.bottom_bar.BottomBar
import com.example.cocktailapp.presentation.home_screen.CocktailCard
import com.example.cocktailapp.presentation.home_screen.HomeScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
                    .padding(start = 16.dp, end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var name by rememberSaveable { mutableStateOf("") }

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = "Name") },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedLabelColor = Color(0xfff7f7f7),
                            focusedLabelColor = Color(0xfff7f7f7),
                            unfocusedBorderColor = Color(0xfff7f7f7),
                            focusedBorderColor = Color(0xfff7f7f7),
                            unfocusedTextColor = Color(0xfff7f7f7),
                            focusedTextColor = Color(0xfff7f7f7)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {
                            homeScreenViewModel.getCocktailsByName(name)
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff85aff7),
                            contentColor = Color(0xfff7f7f7)
                        )
                    ) {
                        Text(
                            text = "Find cocktail",
                            fontSize = 20.sp
                        )
                    }
                }
            }

            val cocktails = homeScreenViewModel.cocktailsByName.drinks
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 32.dp, end = 32.dp)
            ) {
                if((cocktails != null) && (cocktails[0].idDrink != "")) {
                    items(cocktails) { cocktail ->
                        CocktailCard(
                            title = cocktail.strDrink,
                            homeScreenViewModel = homeScreenViewModel,
                            picture = cocktail.strDrinkThumb,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}