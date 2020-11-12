package br.com.house.digital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.house.digital.databinding.ActivityMainBinding
import br.com.house.digital.helper.RecyclerViewItemClickListener
import br.com.house.digital.model.Restaurant
import br.com.house.digital.ui.adapter.AdapterRestaurant

class MainActivity : AppCompatActivity(),
    AdapterView.OnItemClickListener,
    RecyclerViewItemClickListener.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private var listRestaurants = getRestaurants()
    private lateinit var adapterRestaurant: AdapterRestaurant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.includeToolbar.materialToolbar
        setSupportActionBar(toolbar)

        setTitle(R.string.title_default)
        initRecyclerView()
    }

    private fun getRestaurants(): ArrayList<Restaurant> {
        val restaurantA = Restaurant(
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00",
            R.drawable.restaurant1
        )

        val restaurantB = Restaurant(
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00",
            R.drawable.restaurant2
        )

        val restaurantC = Restaurant(
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00",
            R.drawable.restaurant3
        )

        val restaurantD = Restaurant(
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00",
            R.drawable.restaurant4
        )

        return arrayListOf(restaurantA, restaurantB, restaurantC, restaurantD)
    }

    private fun initRecyclerView() {
        adapterRestaurant = AdapterRestaurant(listRestaurants)

        with(binding) {
            recyclerViewRestaurants.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewRestaurants.setHasFixedSize(true)
            recyclerViewRestaurants.adapter = adapterRestaurant

            recyclerViewRestaurants.addOnItemTouchListener(
                RecyclerViewItemClickListener(
                    applicationContext,
                    recyclerViewRestaurants,
                    this@MainActivity
                )
            )
        }
    }

    override fun onItemClick(view: View?, position: Int) {
        val restaurant: Restaurant = listRestaurants.get(position)
        Toast.makeText(applicationContext, "Restaurant: " + restaurant.name, Toast.LENGTH_SHORT)
            .show()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(view: View?, position: Int) {
        val restaurant: Restaurant = listRestaurants.get(position)
        Toast.makeText(applicationContext, "Restaurant: " + restaurant.address, Toast.LENGTH_SHORT)
            .show()
    }
}