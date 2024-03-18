package com.example.cocktailapp.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.remote.CocktailData
import com.example.cocktailapp.data.remote.Drink
import com.example.cocktailapp.data.repository.CocktailRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepositoryImpl: CocktailRepositoryImpl
): ViewModel() {

    //All cocktails in glass get function
    var cocktailsInGlass by mutableStateOf(CocktailData(listOf(Drink())))
    fun getAllCocktailsInGlass() {
        viewModelScope.launch {
            cocktailsInGlass = cocktailRepositoryImpl.getCocktailsInGlass().body()!!
        }
    }

    //All cocktails in flute get function
    var cocktailsInFlute by mutableStateOf(CocktailData(listOf(Drink())))
    fun getAllCocktailsInFlute() {
        viewModelScope.launch {
            cocktailsInFlute = cocktailRepositoryImpl.getCocktailsInFlute().body()!!
        }
    }

    //All nonalcoholic cocktails
    var nonAlcoholicCocktails by mutableStateOf(CocktailData(listOf(Drink())))
    fun getAllNonalcoholicCocktails() {
        viewModelScope.launch {
            nonAlcoholicCocktails = cocktailRepositoryImpl.getNonAlcoholicCocktails().body()!!
        }
    }

}