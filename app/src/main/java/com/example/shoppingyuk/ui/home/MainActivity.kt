package com.example.shoppingyuk.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppingyuk.R
import com.example.shoppingyuk.databinding.ActivityMainBinding
import com.example.shoppingyuk.ui.auth.AuthActivity
import com.example.shoppingyuk.ui.auth.ShoppingyukAuth


class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnLogout.setOnClickListener {
            ShoppingyukAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}