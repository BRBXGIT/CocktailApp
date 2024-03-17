package com.example.cocktailapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cocktail(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val url: String
)
