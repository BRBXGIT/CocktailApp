package com.example.cocktailapp.di

import android.content.Context
import androidx.room.Room
import com.example.cocktailapp.data.api.CocktailApi
import com.example.cocktailapp.data.db.CocktailDao
import com.example.cocktailapp.data.db.CocktailDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCocktailDao(@ApplicationContext appContext: Context): CocktailDao {
        return Room.databaseBuilder(
            appContext,
            CocktailDb::class.java,
            "CocktailDb"
        ).build().CocktailDao()
    }

    @Provides
    @Singleton
    fun provideCocktailApi(): CocktailApi {
        return Retrofit.Builder()
            .baseUrl("www.thecocktaildb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}