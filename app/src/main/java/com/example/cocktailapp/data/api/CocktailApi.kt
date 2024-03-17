package com.example.cocktailapp.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CocktailApi {

    @GET("/api/json/v1/1/filter.php?g=Cocktail_glass")
    suspend fun getCocktailsInGlass(): Response<CocktailData>

    @GET("api/json/v1/1/filter.php?g=Champagne_flute")
    suspend fun getCocktailsInFlute(): Response<CocktailData>

    @GET("api/json/v1/1/filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicCocktails(): Response<CocktailData>

    @GET("api/json/v1/1/search.php?s={cocktail}")
    suspend fun getCocktailByName(@Path("cocktail") cocktail: String): Response<CocktailData>
}