package com.example.cocktailapp.domain.repository

import com.example.cocktailapp.data.db.Cocktail
import com.example.cocktailapp.data.remote.CocktailData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CocktailRepository {


    //Api functions
    suspend fun getCocktailsInGlass(): Response<CocktailData>


    suspend fun getCocktailsInFlute(): Response<CocktailData>


    suspend fun getNonAlcoholicCocktails(): Response<CocktailData>


    suspend fun getCocktailByName(cocktail: String): Response<CocktailData>


    //Local db functions
    suspend fun upsertNewCocktail(cocktail: Cocktail)


    suspend fun deleteCocktail(cocktail: Cocktail)


    fun getAllCocktails(): Flow<List<Cocktail>>
}