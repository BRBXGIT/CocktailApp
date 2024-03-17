package com.example.cocktailapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Cocktail::class],
    version = 1
)
abstract class CocktailDb: RoomDatabase() {

    abstract fun CocktailDao(): CocktailDao
}