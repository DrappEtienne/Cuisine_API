package com.example.cuisine_api.RecetteFinal

data class Recette(
    val id : Int,
    val nom : String,
    val nombres_personnes: String,
    val niveau: String,
    val images: String,
    val video: String
)