package com.example.cuisine_api.RecetteFinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cuisine_api.R
import com.example.monprojetmobile.recette.recette
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recette.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecetteFragment : Fragment() {
    companion object {
        fun newInstance() = RecetteFragment()
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.recette, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://www.thecocktaildb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(RecetteWebservice::class.java)
        val cocktailService = RecetteService(retrofitService)

        cocktailService.getRandomRecette(
            { cocktail ->
                Picasso.get().load(recette.images).into(view.recetteImage)
                view.recetteName.text = cocktail.nom
            }, { error -> TODO() }
        )
    }

}