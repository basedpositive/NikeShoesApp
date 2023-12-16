package com.example.nikeshoesapp.data

import androidx.annotation.DrawableRes

data class ShopProducts(

    @DrawableRes val image: Int,
    val title: String,
    val price: String
)
