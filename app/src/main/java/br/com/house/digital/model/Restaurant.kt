package br.com.house.digital.model

import java.io.Serializable

class Restaurant(
    val name: String,
    var address: String,
    var openingHours: String,
    var resourceImage: Int
) : Serializable