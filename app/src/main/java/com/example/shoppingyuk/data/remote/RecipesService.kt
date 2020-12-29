package com.example.shoppingyuk.data.remote

import com.example.shoppingyuk.data.model.RecipesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesService {
    @GET("/api/recipes/1")
    fun listRecipes() : Call<RecipesList>

    @GET("detail/")
    fun detailRecipes(@Query("url") url: String) : Call<RecipesList>

    @GET("search/")
    fun searchRecipes(@Query("q") query: String) : Call<RecipesList>
}