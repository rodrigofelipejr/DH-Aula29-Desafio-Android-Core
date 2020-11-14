package br.com.house.digital.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.house.digital.databinding.ActivityDishDetailsBinding
import br.com.house.digital.model.Dish

class DishDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDishDetailsBinding
    private var extras: Bundle? = null
    private lateinit var dish: Dish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDishDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar()

        extras = intent.extras
        dish = intent.extras?.get("EXTRA_DISH") as Dish
        setValues()
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
            textViewNameDish.text = dish.name
            textViewDescriptionDish.text = dish.description
            imageViewDishDetails.setImageResource(dish.resourceImage)
        }
    }
}