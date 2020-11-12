package br.com.house.digital.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.house.digital.R
import br.com.house.digital.model.Restaurant

class AdapterRestaurant(private val listRestaurants: ArrayList<Restaurant>) :
    RecyclerView.Adapter<AdapterRestaurant.RestaurantViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRestaurant.RestaurantViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_single_restaurant, parent, false)
        return RestaurantViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterRestaurant.RestaurantViewHolder, position: Int) {
        val restaurant: Restaurant = listRestaurants.get(position)
        holder.imageRestaurant.setImageResource(restaurant.resourceImage)
        holder.textNameRestaurant.text = restaurant.name
        holder.textAddress.text = restaurant.address
        holder.textOpeningHours.text = restaurant.openingHours
    }

    override fun getItemCount() = listRestaurants.size

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageRestaurant: ImageView = itemView.findViewById(R.id.imageViewRestaurant)
        val textNameRestaurant: TextView = itemView.findViewById(R.id.textViewName)
        val textAddress: TextView = itemView.findViewById(R.id.textViewAddress)
        val textOpeningHours: TextView = itemView.findViewById(R.id.textViewOpeningHours)
    }
}