package com.example.cocktailapp.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.remote.CocktailData
import com.example.cocktailapp.data.remote.Drink
import com.example.cocktailapp.data.repository.CocktailRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepositoryImpl: CocktailRepositoryImpl
): ViewModel() {

    //Var for making right api calls and change color of chosen drink
    var chosenCategory by mutableStateOf("")

    //All cocktails in glass get function
    var chosenCocktails by mutableStateOf(CocktailData(listOf(Drink())))
    fun getAllCocktailsInGlass() {
        viewModelScope.launch {
            chosenCocktails = cocktailRepositoryImpl.getCocktailsInGlass().body()!!
        }
    }

    //All cocktails in flute get function
    fun getAllCocktailsInFlute() {
        viewModelScope.launch {
            chosenCocktails = cocktailRepositoryImpl.getCocktailsInFlute().body()!!
        }
    }

    //All nonalcoholic cocktails
    fun getAllNonalcoholicCocktails() {
        viewModelScope.launch {
            chosenCocktails = cocktailRepositoryImpl.getNonAlcoholicCocktails().body()!!
        }
    }

}