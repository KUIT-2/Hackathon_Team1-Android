package com.example.hackathon_team1_android.dao

import android.content.ClipDescription
import com.example.hackathon_team1_android.RestaurantLocations

data class RestaurantInfo_location(
    val restaurant_id: Int,
    val restaurant_name: String,
    val locations: String,
    val description: String,
    val restaurant_img: String, //url
    val rate: Int
)
