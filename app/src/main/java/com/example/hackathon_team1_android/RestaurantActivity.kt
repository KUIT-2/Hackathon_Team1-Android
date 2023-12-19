package com.example.hackathon_team1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon_team1_android.databinding.ActivityRestaurantBinding
import com.google.android.material.tabs.TabLayoutMediator

class RestaurantActivity : AppCompatActivity() {
    lateinit var binding: ActivityRestaurantBinding
    private val tabList = arrayListOf("홈", "메뉴", "사진", "리뷰")

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRestaurantBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.restaurantABtnDate.setOnClickListener {
            //frament_reserve01.xml 하단에 뜨는 부분 구현해야 함
            val reserveFragment = Reserve01Fragment()
            reserveFragment.show(supportFragmentManager, reserveFragment.tag)
        }

        initView()
    }

    private fun initView() {
        binding.restaurantAViewPager.adapter = RestaurantTabLayoutVPAdapter(this)

        // ViewPager와 TabLayout을 연동해주기
        TabLayoutMediator(
            binding.restaurantATablayout,
            binding.restaurantAViewPager
        ) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}