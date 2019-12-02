package com.example.cuisine_api.RecetteFinal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecetteService(
    private val webservice: RecetteWebservice
) {
    fun getRandomRecette(onDone: (RecetteResponse) -> Unit, onError: (Throwable) -> Unit) {
        webservice.getRandomrecette().enqueue(object : Callback<RecetteResponse> {
            override fun onResponse(
                call: Call<RecetteResponse>,
                response: Response<RecetteResponse>
            ) {
                val recetteResponse = response.body()

                onDone(recetteResponse!!)
            }

            override fun onFailure(call: Call<RecetteResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}