package com.example.hackathon_team1_android

import java.io.Serializable

data class DataRestaurant(
    val title: String,
    val info: String,
    val category: String,
    val location: String,
) : Serializable
