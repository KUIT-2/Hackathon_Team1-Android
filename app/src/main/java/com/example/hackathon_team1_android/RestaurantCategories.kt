package com.example.hackathon_team1_android


import com.example.hackathon_team1_android.dao.BaseResponse
import com.example.hackathon_team1_android.dao.getRestaurantListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantCategories {
    @GET("/restaurants/categories")
    fun getRestaurant(
        @Query("category") category: String,
        @Query("pageId") pageId: Int
    ): Call<BaseResponse<getRestaurantListResponse>>
}