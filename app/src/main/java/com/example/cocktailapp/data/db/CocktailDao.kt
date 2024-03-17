package com.example.cocktailapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailDao {

    @Upsert
    suspend fun upsertNewCocktail(cocktail: Cocktail)

    @Delete
    suspend fun deleteCocktail(cocktail: Cocktail)

    @Query("SELECT * FROM cocktail")
    fun getAllCocktails(): Flow<List<Cocktail>>
}