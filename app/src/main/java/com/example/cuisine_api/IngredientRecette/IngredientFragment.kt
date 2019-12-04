package com.example.cuisine_api.IngredientRecette

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.cuisine_api.MainActivity2
import com.example.cuisine_api.IngredientRecette.*
import com.example.cuisine_api.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.page.view.*
import android.view.ViewGroup
import kotlinx.android.synthetic.main.ingredient.view.*


class IngredientFragment : Fragment() {
    companion object {
        fun newInstance() = IngredientFragment()
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.ingredient, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        val ingredientString = bundle!!.getString("ingredient")
        val ingredient = Gson().fromJson(ingredientString,Ingredient::class.java)
        view.textView2.text = ingredient.name

    }
}