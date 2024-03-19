package com.example.cocktailapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cocktail(
    @PrimaryKey
    val title: String
)
