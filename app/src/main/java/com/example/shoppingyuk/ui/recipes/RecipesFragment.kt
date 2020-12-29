package com.example.shoppingyuk.ui.recipes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.shoppingyuk.R
import com.example.shoppingyuk.databinding.FragmentRecipesBinding
import com.example.shoppingyuk.ui.home.MainActivity

class RecipesFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentRecipesBinding

    private val viewModel: RecipesViewModel by lazy { RecipesViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(inflater,container, false).apply {
            viewModel = this@RecipesFragment.viewModel
            lifecycleOwner = this@RecipesFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       init()
        observe()
    }

    private fun init() {
        binding.recycleView.adapter = RecipesAdapter(parent)
        viewModel.listRecipes()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listRecipes()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }
        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            } else if (it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}