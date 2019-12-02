package com.example.cuisine_api

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cuisine_api.RecetteFinal.RecetteFragment

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipe = 10
        for (recipeIndex in 1..recipe) {
            val fragment = RecetteFragment()
            supportFragmentManager.beginTransaction().add(
                flexbox.id, fragment
            ).commit()
        }
    }
}


