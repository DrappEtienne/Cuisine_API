package com.example.monprojetmobile.recette
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailService constructor(
    private val webservice: recetteWebservice
) {
    fun getRandomrecette( onDone: (recette)->Unit, onError: (Throwable)->Unit ) {
        webservice.getRandomrecette().enqueue(object : Callback< Array<recette>> {
            override fun onResponse(
                call: Call< Array<recette>>,
                response: Response< Array<recette>>
            ) {
                //val recetteReponse =  response.body()
               // val recette: recette = recetteReponse[]
        }
            override fun onFailure(call: Call< Array<recette>>, t: Throwable) {
                onError(t)
            }
        })
    }
}