package com.example.hackathon_team1_android

import com.example.hackathon_team1_android.dao.BaseResponse
import com.example.hackathon_team1_android.dao.getRestaurantListResponse
import com.example.hackathon_team1_android.dao.getRestaurantListResponse_location
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantLocations {
    @GET("/restaurants/locations")
    fun getLocation(
        @Query("location") location: String,
        @Query("pageId") pageId: String
    ): Call<BaseResponse<getRestaurantListResponse_location>>
}