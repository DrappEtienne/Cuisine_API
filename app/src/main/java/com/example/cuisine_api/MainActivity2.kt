package com.example.cuisine_api

import android.os.Bundle
import android.view.CollapsibleActionView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.cuisine_api.RecetteFinal.RecetteFragment
import com.example.cuisine_api.RecetteFinal.RecetteService
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
        textView.text=id.toString()
    }
}


