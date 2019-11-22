package com.example.cuisine_api.RecetteFinal

import retrofit2.Call
import retrofit2.http.GET

interface RecetteWebservice{
    @GET("/api/marmiton/entrees")
    fun getRandomrecette(): Call<Array<Recette>>
}

