package com.example.hackathon_team1_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon_team1_android.databinding.ActivityRestaurantListBinding

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
        restaurantAdapter = RestaurantAdatper(restaurantList)
        binding.resListARecyclerView.adapter = restaurantAdapter
        binding.resListARecyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        restaurantAdapter!!.setOnItemClickListener(object : RestaurantAdatper.OnItemClickListener {
            override fun onItemClick(res: DataRestaurant) {
                val intent = Intent(applicationContext, RestaurantActivity::class.java)
                intent.putExtra("Key", res)
                startActivity(intent)
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