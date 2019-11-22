package com.example.cuisine_api

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cuisine_api.RecetteFinal.RecetteFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recette.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = 10
        for (cardIndex in 1..cards) {
            val fragment = RecetteFragment()
            supportFragmentManager.beginTransaction().add(
                flexbox.id, fragment
            ).commit()
        }
    }
}


