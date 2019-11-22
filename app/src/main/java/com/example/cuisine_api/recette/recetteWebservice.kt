package com.example.monprojetmobile.recette

import retrofit2.Call
import retrofit2.http.GET

interface recetteWebservice{
    @GET("/api/marmiton/entrees")
    fun getRandomrecette(): Call<Array<recette>>
}