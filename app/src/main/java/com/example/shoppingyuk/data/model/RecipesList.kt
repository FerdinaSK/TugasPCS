package com.example.shoppingyuk.data.model

data class RecipesList(
    val results: List<Recipes> = arrayListOf(),
    val method: String,
    val status: String
    )
