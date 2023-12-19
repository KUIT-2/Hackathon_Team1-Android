package com.example.hackathon_team1_android.dao

import com.google.gson.annotations.SerializedName

data class getRestaurantListResponse(
    @SerializedName("restaurant_list") val restaurant_list : List<RestaurantInfo>,
    @SerializedName("has_next") val has_next : Boolean,
    @SerializedName("cur_page") val cur_page : Int

)