package com.example.hackathon_team1_android.dao

import android.util.Log
import com.example.hackathon_team1_android.ApplicationClass
import com.example.hackathon_team1_android.RestaurantCategories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.Locale.Category


class getRestaurantService {
    private var CategoryService = ApplicationClass.retrofit.create(RestaurantCategories::class.java)

    private lateinit var categorizeView: CategorizeView
    fun setCategorizeView(categorizeView: CategorizeView) {
        this.categorizeView = categorizeView
    }

    fun getCategory(category: String, pageId: Int) {
        //get방식은 query를 요구 -> 각각 따로 넣기
        CategoryService.getRestaurant(category, pageId).enqueue(object :
            Callback<BaseResponse<getRestaurantListResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<getRestaurantListResponse>>,
                response: Response<BaseResponse<getRestaurantListResponse>>
            ) {
                val resp = response.body()
                Log.d("Categorize response", resp.toString())
                when (resp!!.code) {
                    1000 -> categorizeView.CategorizeSuccess(resp.result.restaurant_list[0])
                    else -> categorizeView.CategorizeFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(
                call: Call<BaseResponse<getRestaurantListResponse>>,
                t: Throwable
            ) {
                Log.d("Categorize failed", t.toString())
            }

        })
    }

}