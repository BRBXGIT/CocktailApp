package com.example.cocktailapp.data.repository

import com.example.cocktailapp.data.remote.CocktailApi
import com.example.cocktailapp.data.remote.CocktailData
import com.example.cocktailapp.domain.repository.CocktailRepository
import retrofit2.Response
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailApi: CocktailApi
): CocktailRepository {
    override suspend fun getCocktailsInFlute(): Response<CocktailData> {
        return cocktailApi.getCocktailsInFlute()
    }

    override suspend fun getCocktailsInGlass(): Response<CocktailData> {
        return cocktailApi.getCocktailsInGlass()
    }

    override suspend fun getNonAlcoholicCocktails(): Response<CocktailData> {
        return cocktailApi.getNonAlcoholicCocktails()
    }

    override suspend fun getCocktailByName(cocktail: String): Response<CocktailData> {
        return cocktailApi.getCocktailByName(cocktail)
    }
}