package com.example.cuisine_api.IngredientRecette

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.cuisine_api.MainActivity2
import com.example.cuisine_api.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.page.view.*

class IngredientFragment : Ingredient() {
    companion object {
        fun newInstance() = IngredientFragment()
    }
    override fun onCreateView2(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.page, container, false)
        return view
    }
    override fun onCreate2(savedInstanceState: Bundle?) {
        super.onCreate2(savedInstanceState)

    }

    override fun onViewCreated2(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated2(view, savedInstanceState)

        val bundle = this.arguments
        val recetteString = bundle!!.getString("ingredient")
        val ingredient = Gson().fromJson(ingredientstring,Ingredient::class.java)
        view.ingredientName2.text = ingredient.name

    }