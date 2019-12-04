package com.example.cuisine_api.IngredientRecette

import com.example.cuisine_api.RecetteFinal.RecetteResponse
import retrofit2.Call
import retrofit2.http.GET

interface IngredientWebservice {

    @GET("ingredientWidget.json/?apiKey=f1abb0f0bbab4ec49567795017869ca6")
    fun getIngredient(): Call<IngredientResponse>
}