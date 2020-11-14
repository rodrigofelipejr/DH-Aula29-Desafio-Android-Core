package br.com.house.digital.model

import java.io.Serializable

class Restaurant(
    val name: String,
    val address: String,
    val openingHours: String,
    val resourceImage: Int,
    val dishes: ArrayList<Dish>
) : Serializable