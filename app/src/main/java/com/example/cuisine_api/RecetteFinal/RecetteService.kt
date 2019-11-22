package com.example.cuisine_api.RecetteFinal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecetteService(
    private val webservice: RecetteWebservice
) {
    fun getRandomRecette(onDone: (Array<Recette>) -> Unit, onError: (Throwable) -> Unit) {
        webservice.getRandomrecette().enqueue(object : Callback<Array<Recette>> {
            override fun onResponse(
                call: Call<Array<Recette>>,
                response: Response<Array<Recette>>
            ) {
                val recetteReponse = response.body()
                onDone(recetteReponse!!)
            }

            override fun onFailure(call: Call<Array<Recette>>, t: Throwable) {
                onError(t)
            }
        })
    }
}