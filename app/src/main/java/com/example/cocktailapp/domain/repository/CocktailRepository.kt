package com.example.cocktailapp.domain.repository

import com.example.cocktailapp.data.db.Cocktail
import com.example.cocktailapp.data.remote.CocktailData
import retrofit2.Response

interface CocktailRepository {


    //Api functions
    suspend fun getCocktailsInGlass(): Response<CocktailData>

    suspend fun getCocktailsInFlute(): Response<CocktailData>

    suspend fun getNonAlcoholicCocktails(): Response<CocktailData>

    suspend fun getCocktailByName(cocktail: String): Response<CocktailData>
}