package com.example.shoppingyuk.ui.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingyuk.R

class RecipesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
    }

    companion object {
        const val OPEN_RECIPES = "open_recipes"
    }
}