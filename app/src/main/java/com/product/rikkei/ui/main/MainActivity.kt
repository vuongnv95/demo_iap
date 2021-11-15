package com.product.rikkei.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.product.rikkei.R
import com.product.rikkei.databinding.ActivityMainBinding
import com.product.rikkei.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, HomeFragment.newInstance(), HomeFragment.TAG)
            .addToBackStack(HomeFragment.TAG)
            .commit()

//        startActivity(Intent(this, PremiumActivity::class.java))

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}