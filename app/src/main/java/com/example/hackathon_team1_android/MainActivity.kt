package com.example.hackathon_team1_android

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hackathon_team1_android.dao.BaseResponse
import com.example.hackathon_team1_android.dao.CategorizeView
import com.example.hackathon_team1_android.dao.RestaurantInfo
import com.example.hackathon_team1_android.dao.getRestaurantListResponse
import com.example.hackathon_team1_android.dao.getRestaurantService
import com.example.hackathon_team1_android.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity(), CategorizeView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_search, R.id.navigation_timeline, R.id.navigation_myDining, R.id.navigation_login
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        //바텀 네비게이션을 상단바에도 만들어주는 코드(지우는것이 나음)
        val service = getRestaurantService()
        service.setCategorizeView(this)
        service.getCategory("oma", 1)

        navView.setupWithNavController(navController)

    }

    override fun CategorizeSuccess(RestaurantInfo : RestaurantInfo) {
        //임시로 오버라이드 해놓은 것.
        Log.d("test", RestaurantInfo.toString())
    }

    override fun CategorizeFailure(code: Int, msg: String) {
        //임시로 오버라이드 해놓은 것.
        Log.d("test2", code.toString())
    }
}