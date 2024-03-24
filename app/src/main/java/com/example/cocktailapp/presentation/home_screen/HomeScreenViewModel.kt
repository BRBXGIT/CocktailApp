package com.example.cocktailapp.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.db.Cocktail
import com.example.cocktailapp.data.remote.CocktailData
import com.example.cocktailapp.data.remote.Drink
import com.example.cocktailapp.data.repository.CocktailRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepositoryImpl: CocktailRepositoryImpl
): ViewModel() {

    //Category for making right api calls(glass, flute or nonalcoholic)
    var chosenCategory by mutableStateOf("")

    //Cocktails chosen by category and api function under it
    var chosenCocktails by mutableStateOf(CocktailData(listOf(Drink())))
    fun getAllCocktailsInGlass() {
        viewModelScope.launch {
            chosenCocktails = cocktailRepositoryImpl.getCocktailsInGlass().body()!!
        }
    }


    fun getAllCocktailsInFlute() {
        viewModelScope.launch {
            chosenCocktails = cocktailRepositoryImpl.getCocktailsInFlute().body()!!
        }
    }


    fun getAllNonalcoholicCocktails() {
        viewModelScope.launch {
            chosenCocktails = cocktailRepositoryImpl.getNonAlcoholicCocktails().body()!!
        }
    }


    //Var which keeps only one cocktail which user click
    var currentCocktail by mutableStateOf(CocktailData(listOf(Drink())))
    fun getCocktailByName(name: String) {
        viewModelScope.launch {
            currentCocktail = cocktailRepositoryImpl.getCocktailByName(name).body()!!
        }
    }


    var cocktailsByName by mutableStateOf(CocktailData(listOf(Drink())))
    fun getCocktailsByName(name: String) {
        viewModelScope.launch {
            cocktailsByName = cocktailRepositoryImpl.getCocktailByName(name).body()!!
        }
    }


    //Local db functions
    fun upsertNewCocktailToFavorites(title: String) {
        viewModelScope.launch {
            cocktailRepositoryImpl.upsertNewCocktail(Cocktail(title))
        }
    }


    fun deleteCocktailFromFavorites(title: String) {
        viewModelScope.launch {
            cocktailRepositoryImpl.deleteCocktail(Cocktail(title))
        }
    }


    fun getAllFavoriteCocktails(): Flow<List<Cocktail>> {
        return cocktailRepositoryImpl.getAllCocktails()
    }

}