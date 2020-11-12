package br.com.house.digital.ui.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.house.digital.R
import br.com.house.digital.databinding.ActivityRestaurantDetailsBinding
import br.com.house.digital.model.Restaurant

class RestaurantDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantDetailsBinding
    private var extras: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar()

        extras = intent.extras
        val restaurant = intent.extras?.get("EXTRA_RESTAURANT") as Restaurant
        setValues(restaurant)
    }

    private fun initToolbar() {
        val toolbar = binding.includeToolbar.materialToolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.includeToolbar.materialToolbar.setBackgroundColor(Color.TRANSPARENT)
        binding.includeToolbar.materialAppBarLayout.setBackgroundColor(Color.TRANSPARENT)

        setTitle("")
    }

    private fun setValues(restaurant: Restaurant) {
        with(binding) {
            textViewNameRestaurant.text = restaurant.name
            imageViewRestaurantDetails.setImageResource(restaurant.resourceImage)
        }
    }
}