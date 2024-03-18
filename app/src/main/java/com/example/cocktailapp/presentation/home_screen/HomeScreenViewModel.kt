package com.example.cocktailapp.presentation.home_screen

import androidx.lifecycle.ViewModel
import com.example.cocktailapp.data.repository.CocktailRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepositoryImpl: CocktailRepositoryImpl
): ViewModel() {

}