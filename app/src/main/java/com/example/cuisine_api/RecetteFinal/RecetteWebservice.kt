package com.example.cuisine_api.RecetteFinal

import retrofit2.Call
import retrofit2.http.GET

interface RecetteWebservice{
    @GET("/recipes/search/?apiKey=f1abb0f0bbab4ec49567795017869ca6")
    fun getRandomrecette(): Call<RecetteResponse>
}

