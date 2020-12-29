package com.example.shoppingyuk.data.repository

import com.example.shoppingyuk.data.model.ActionState
import com.example.shoppingyuk.data.model.Recipes
import com.example.shoppingyuk.data.remote.RecipesService
import com.example.shoppingyuk.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class RecipesRepository {
    private val recipesService: RecipesService by lazy { RetrofitApi.recipesService() }

    suspend fun listRecipes() : ActionState<List<Recipes>> {
        return try {
            val list = recipesService.listRecipes().await()
            ActionState(list.results)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
    suspend fun detailRecipes(url: String) : ActionState<Recipes> {
       return try {
            val list = recipesService.detailRecipes(url).await()
            ActionState(list.results.first())
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
    suspend fun searchRecipes(query: String) : ActionState<List<Recipes>> {
       return try {
            val list = recipesService.searchRecipes(query).await()
            ActionState(list.results)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}