package com.example.cuisine_api

import android.os.Bundle
import android.view.CollapsibleActionView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.cuisine_api.IngredientRecette.IngredientWebservice
import com.example.cuisine_api.RecetteFinal.RecetteFragment
import com.example.cuisine_api.IngredientRecette.*
import com.example.cuisine_api.RecetteFinal.RecetteWebservice
import com.google.gson.Gson
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.page.*
import kotlinx.android.synthetic.main.recette.view.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page)
        var bundle :Bundle ?=intent.extras
        val id= bundle!!.getInt("recette_ID")
        val title= bundle!!.getString("recette_title")
        val serving= bundle!!.getString("recette_serving")
        val image= bundle!!.getString("recette_image")
        textView.text=title.toString()
        textView.text=serving.toString()
        Picasso.get().load("https://spoonacular.com/recipeImages/"+image).into(fondImage)
        val idString=id.toString()
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.spoonacular.com/recipes/"+idString+"/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(IngredientWebservice::class.java)
        val ingredientService = IngredientService(retrofitService)

        ingredientService.getIngredient(
            { ingredients ->
                for(ingredient in ingredients.ingredients){
                    val bundle = Bundle()
                    val ingredientString = Gson().toJson(ingredient).toString()
                    bundle.putString("ingredient", ingredientString)


                    val fragment = IngredientFragment()
                    fragment.arguments=bundle
                    supportFragmentManager.beginTransaction().add(
                        flexbox2.id, fragment
                    ).commit()
                }
            }, { error -> throw error })
    }
}


