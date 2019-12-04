package com.example.cuisine_api.IngredientRecette

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngredientService(
    private val webservice: IngredientWebservice
) {
    fun getIngredient(onDone: (IngredientResponse) -> Unit, onError: (Throwable) -> Unit) {
        webservice.getIngredient().enqueue(object : Callback<IngredientResponse> {
            override fun onResponse(
                call: Call<IngredientResponse>,
                response: Response<IngredientResponse>
            ) {
                val ingredientResponse = response.body()

                onDone(ingredientResponse!!)
            }

            override fun onFailure(call: Call<IngredientResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}