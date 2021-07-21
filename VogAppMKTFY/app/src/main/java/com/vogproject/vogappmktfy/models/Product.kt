package com.vogproject.vogappmktfy.models

import java.text.NumberFormat

data class Product(
    val id: String,
    val image: String,
    val productName: String,
    val price: Double
) {
    val formattedPrice = NumberFormat.getCurrencyInstance().format(price)
}
