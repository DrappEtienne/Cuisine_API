package com.example.cuisine_api

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cuisine_api.RecetteFinal.RecetteFragment
import com.example.cuisine_api.RecetteFinal.RecetteService
import com.example.cuisine_api.RecetteFinal.RecetteWebservice
import com.google.gson.Gson
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recette.view.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(RecetteWebservice::class.java)
        val recetteService = RecetteService(retrofitService)

        recetteService.getRandomRecette(
            { recettes ->
                for(recette in recettes.results){
                    val bundle = Bundle()
                    val recetteString = Gson().toJson(recette).toString()
                    bundle.putString("recette", recetteString)


                    val fragment = RecetteFragment()
                    fragment.arguments=bundle
                    supportFragmentManager.beginTransaction().add(
                        flexbox.id, fragment
                    ).commit()
                }
            }, { error -> throw error }
        )
    }
}


