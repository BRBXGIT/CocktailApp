package com.example.cocktailapp.di

import android.content.Context
import androidx.room.Room
import com.example.cocktailapp.data.remote.CocktailApi
import com.example.cocktailapp.data.db.CocktailDao
import com.example.cocktailapp.data.db.CocktailDb
import com.example.cocktailapp.data.db.CocktailDb_Impl
import com.example.cocktailapp.data.repository.CocktailRepositoryImpl
import com.example.cocktailapp.domain.repository.CocktailRepository
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

    //Provide dao for local db
    @Provides
    @Singleton
    fun provideCocktailDao(@ApplicationContext appContext: Context): CocktailDao {
        return Room.databaseBuilder(
            appContext,
            CocktailDb::class.java,
            "CocktailDb"
        ).build().CocktailDao()
    }

    //Provide cocktail api
    @Provides
    @Singleton
    fun provideCocktailApi(): CocktailApi {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    //Provide repository implementation
    @Provides
    @Singleton
    fun provideCocktailRepositoryImpl(cocktailApi: CocktailApi): CocktailRepository {
        return CocktailRepositoryImpl(cocktailApi)
    }
}