package com.example.monprojetmobile.recette
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.monprojetmobile.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recette.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class recetteFragment : Fragment() {
    companion object {
        fun newInstance() = recetteFragment()
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
        val retrofitService = retrofit.create(recetteWebservice::class.java)
        val cocktailService = CocktailService(retrofitService)

        cocktailService.getRandomrecette(
            { cocktail ->
                Picasso.get().load(cocktail.images).into(view.cocktailImage)
                view.cocktailName.text = cocktail.nom
            }, { error -> TODO() }
        )
    }

}