package com.example.cocktailapp.data.repository

import com.example.cocktailapp.data.db.Cocktail
import com.example.cocktailapp.data.db.CocktailDao
import com.example.cocktailapp.data.remote.CocktailApi
import com.example.cocktailapp.data.remote.CocktailData
import com.example.cocktailapp.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val cocktailDao: CocktailDao
): CocktailRepository {


    //Api functions
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


    //Local db functions
    override fun getAllCocktails(): Flow<List<Cocktail>> {
        return cocktailDao.getAllCocktails()
    }


    override suspend fun deleteCocktail(cocktail: Cocktail) {
        return cocktailDao.deleteCocktail(cocktail)
    }


    override suspend fun upsertNewCocktail(cocktail: Cocktail) {
        return cocktailDao.upsertNewCocktail(cocktail)
    }

}