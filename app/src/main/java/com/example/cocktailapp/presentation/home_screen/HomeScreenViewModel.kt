package com.example.cocktailapp.presentation.home_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.api.CocktailApi
import com.example.cocktailapp.data.api.CocktailData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailApi: CocktailApi
): ViewModel() {

    //All data of cocktails in glass
    fun getAllCocktailsInGlass(): MutableLiveData<Response<CocktailData>> {
        val result = MutableLiveData<Response<CocktailData>>()
        viewModelScope.launch {
            result.postValue(cocktailApi.getCocktailsInGlass())
        }
        return result
    }

    //All data of cocktails in flute
    fun getAllCocktailsInFlute(): MutableLiveData<Response<CocktailData>> {
        val result = MutableLiveData<Response<CocktailData>>()
        viewModelScope.launch {
            result.postValue(cocktailApi.getCocktailsInFlute())
        }
        return result
    }

    //All data of nonalcoholic cocktails
    fun getAllNonAlcoholicCocktails(): MutableLiveData<Response<CocktailData>> {
        val result = MutableLiveData<Response<CocktailData>>()
        viewModelScope.launch {
            result.postValue(cocktailApi.getNonAlcoholicCocktails())
        }
        return result
    }
}