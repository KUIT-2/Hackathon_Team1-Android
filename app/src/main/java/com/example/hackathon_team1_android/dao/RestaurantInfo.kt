package com.example.hackathon_team1_android.dao

data class RestaurantInfo(
    val restaurant_id: Int,
    val restaurant_name: String,
    val restaurant_img: String,
    val description: String,
    val location: String,
    val lunch_price: Int,
    val dinner_price: Int,
    val maximum_price: Int,
    val minimum_price: Int,
    val rate: Float
)
