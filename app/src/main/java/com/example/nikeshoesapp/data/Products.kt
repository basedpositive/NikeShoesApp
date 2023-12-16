package com.example.nikeshoesapp.data

import androidx.annotation.DrawableRes

data class Products(
    val textMedium: String,
    val textLow: String,
    val textShop: String,
    @DrawableRes val image: Int
)