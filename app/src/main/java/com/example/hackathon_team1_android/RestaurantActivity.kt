package com.example.hackathon_team1_android

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon_team1_android.databinding.ActivityRestaurantBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

class RestaurantActivity : AppCompatActivity() {
    lateinit var binding: ActivityRestaurantBinding
    private val tabList = arrayListOf("홈", "메뉴", "사진", "리뷰")

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRestaurantBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.stuffABtnBack.setOnClickListener {
            finish()
        }

        binding.restaurantABtnDate.setOnClickListener {
            //frament_reserve01.xml 하단에 뜨는 부분 구현
            val reserveFragment = Reserve01Fragment()
            reserveFragment.show(supportFragmentManager, reserveFragment.tag)
        }

        // RestaurantListActivity에서 intent로 정보 받아오기
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Key", DataRestaurant::class.java)
        } else {
            intent.getSerializableExtra("Key") as DataRestaurant
        } ?: DataRestaurant("temp", "temp", "temp", "temp")

        // intent에 담긴 정보 받아와서 화면에 반영
        binding.restaurantATvTitle.text = data.title
        binding.restaurantATvInfo.text = data.info
        binding.restaurantATvCategory.text = data.category
        binding.restaurantATvLocation.text = data.location

        initView()
    }

    fun showReserve02Fragment(fragment: Reserve02Fragment) {
        //frament_reserve02.xml 하단에 뜨는 부분 구현
        fragment.show(supportFragmentManager, fragment.tag)
    }

    fun showReserveCheckFragment() {
        //frament_reserve_check.xml 하단에 뜨는 부분 구현
        val reserveFragment = ReserveCheckFragment()
        reserveFragment.show(supportFragmentManager, reserveFragment.tag)
    }

    fun showReserveDoneFragment() {
        //frament_reserve_done.xml 하단에 뜨는 부분 구현
        val reserveFragment = ReserveDoneFragment()
        reserveFragment.show(supportFragmentManager, reserveFragment.tag)
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