package br.com.house.digital.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import br.com.house.digital.databinding.ActivityRestaurantDetailsBinding
import br.com.house.digital.model.Restaurant
import br.com.house.digital.ui.adapter.AdapterDishes


class RestaurantDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantDetailsBinding
    private var extras: Bundle? = null
    private lateinit var gridDishes: GridView
    private lateinit var restaurant: Restaurant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar()

        extras = intent.extras

        if (extras != null) {
            restaurant = intent.extras?.get("EXTRA_RESTAURANT") as Restaurant
            setValues()
            setValuesGridView()
        }
    }

    private fun setValuesGridView() {
        gridDishes = binding.gridViewDishes

        val adapterDishes = AdapterDishes(this@RestaurantDetailsActivity, restaurant.dishes)
        gridDishes.adapter = adapterDishes

        gridDishes.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                val intent = Intent(this@RestaurantDetailsActivity, DishDetailsActivity::class.java)
                intent.putExtra("EXTRA_DISH", restaurant.dishes[position])

                startActivity(intent)
            }
    }

    private fun initToolbar() {
        val toolbar = binding.includeToolbar.materialToolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            this.stopLockTask();
            this.onBackPressed();
        }

        binding.includeToolbar.materialAppBarLayout.setBackgroundColor(Color.TRANSPARENT)
        binding.includeToolbar.materialAppBarLayout.targetElevation = 0f

        binding.includeToolbar.materialToolbar.setBackgroundColor(Color.TRANSPARENT)

        setTitle("")
    }

    private fun setValues() {
        with(binding) {
            textViewNameRestaurant.text = restaurant.name
            imageViewRestaurantDetails.setImageResource(restaurant.resourceImage)
        }
    }
}