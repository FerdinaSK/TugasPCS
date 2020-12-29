package com.example.shoppingyuk.ui.recipes

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shoppingyuk.R
import com.example.shoppingyuk.data.model.Recipes
import com.example.shoppingyuk.databinding.ItemRecipesBinding
import com.example.shoppingyuk.ui.base.BaseAdapter

class RecipesAdapter(val context: Context) : BaseAdapter<Recipes>(R.layout.item_recipes) {
    override fun onBind(binding: ViewDataBinding?, data: Recipes) {
        val mBinding = binding as ItemRecipesBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: Recipes) {
        val intent =  Intent(context, RecipesActivity::class.java)
        intent.putExtra(RecipesActivity.OPEN_RECIPES, data)
        context.startActivity(intent)
    }
}