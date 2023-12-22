package com.example.hackathon_team1_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon_team1_android.dao.BaseResponse
import com.example.hackathon_team1_android.dao.RestaurantInfo
import com.example.hackathon_team1_android.dao.getRestaurantListResponse
import com.example.hackathon_team1_android.databinding.ActivityRestaurantListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantListActivity : AppCompatActivity() {
    lateinit var binding: ActivityRestaurantListBinding
    private var restaurantList: ArrayList<DataRestaurant> = arrayListOf()
    private var restaurantAdapter: RestaurantAdatper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRestaurantListBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.resListABtnBack.setOnClickListener {
            finish()
        }

        initRestaurants()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        restaurantAdapter = RestaurantAdatper(arrayListOf())
        binding.resListARecyclerView.adapter = restaurantAdapter
        binding.resListARecyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        restaurantAdapter!!.setOnItemClickListener(object : RestaurantAdatper.OnItemClickListener {
            override fun onItemClick(res: RestaurantInfo) {
                val intent = Intent(applicationContext, RestaurantActivity::class.java)
                intent.putExtra("Key", res)
                startActivity(intent)
            }
        })



        var CategoryService = ApplicationClass.retrofit.create(RestaurantCategories::class.java)
        CategoryService.getRestaurant("oma", 1).enqueue(object :
            Callback<BaseResponse<getRestaurantListResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<getRestaurantListResponse>>,
                response: Response<BaseResponse<getRestaurantListResponse>>
            ) {

                if(response.isSuccessful){
                    val resp = response.body()
                    Log.d("Categorize response", resp.toString())
                    restaurantAdapter!!.setData(resp!!.result.restaurant_list)


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

    private fun initRestaurants() {
        restaurantList.addAll(
            arrayListOf(
                DataRestaurant("가게1", "설명1", "한우오마카세", "삼성"),
                DataRestaurant("가게2", "설명2", "한우오마카세", "여의도"),
                DataRestaurant("가게3", "설명3", "한우오마카세", "하남"),
                DataRestaurant("가게4", "설명4", "한우오마카세", "마장동"),
                DataRestaurant("가게5", "설명5", "한우오마카세", "압구정"),
            )
        )
    }
}