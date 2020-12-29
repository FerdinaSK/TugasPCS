package com.example.shoppingyuk.ui.recipes

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingyuk.data.model.ActionState
import com.example.shoppingyuk.data.model.Recipes
import com.example.shoppingyuk.data.repository.RecipesRepository
import kotlinx.coroutines.launch

class RecipesViewModel : ViewModel() {
    private val repo: RecipesRepository by lazy { RecipesRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>> ()

    val listResp = MutableLiveData<List<Recipes>> ()
    val detailResp = MutableLiveData<Recipes>()
    val searchResp = MutableLiveData<List<Recipes>>()

    val url = MutableLiveData("")
    val query =  MutableLiveData("")

    fun listRecipes(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listRecipes()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailRecipes(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailRecipes(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            } }
    }

    fun searchRecipes(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchRecipes(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}