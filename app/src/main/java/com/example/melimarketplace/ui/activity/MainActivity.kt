package com.example.melimarketplace.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.melimarketplace.NavGraphMarketPlaceDirections
import com.example.melimarketplace.R
import com.example.melimarketplace.databinding.ActivityMainBinding
import com.example.melimarketplace.ui.fragment.MarketPlaceListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MarketPlaceListFragment.MarketPlaceListListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp() or super.onSupportNavigateUp()
    }

    override fun goToDetail(id: String) {
        val action = NavGraphMarketPlaceDirections.actionToDetail(id)
        findNavController(R.id.navHostFragment).navigate(action)
    }
}