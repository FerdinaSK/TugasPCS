package com.example.shoppingyuk.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
<<<<<<< HEAD
=======
import androidx.navigation.findNavController
>>>>>>> ecd1673... first commit
import com.example.shoppingyuk.R
import com.example.shoppingyuk.databinding.ActivityMainBinding
import com.example.shoppingyuk.ui.auth.AuthActivity
import com.example.shoppingyuk.ui.auth.ShoppingyukAuth


class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
<<<<<<< HEAD
        binding.btnLogout.setOnClickListener {
            ShoppingyukAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
=======

        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_recipe -> navigate(R.id.recipesFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
    findNavController(R.id.navHost).navigate(id)
        return true
    }
>>>>>>> ecd1673... first commit
}