package com.example.hackathon_team1_android.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackathon_team1_android.HomeBannerAdapter
import com.example.hackathon_team1_android.R
import com.example.hackathon_team1_android.RestaurantListActivity
import com.example.hackathon_team1_android.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding


    //자동 전환을 위해 추가한 요소.
    var currentPosition = 0

//    val imageArray = listOf(
//        R.drawable.banner1,
//        R.drawable.banner2,
//        R.drawable.banner4,
//        R.drawable.banner5,
//        R.drawable.banner6
//    )

    val imageArray: ArrayList<Int> = arrayListOf<Int>(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner4,
        R.drawable.banner5,
        R.drawable.banner6
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)

        initViewPager()

//자동 전환
        val thread = Thread(pagerRunnable())
        thread.start()
        //자동전환

        binding.mainAIvDetailMenu2.setOnClickListener {
            val intent = Intent(requireContext(), RestaurantListActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    //자동전환
    val handler = Handler(Looper.getMainLooper()) {
        setPage()
        true





    }

    private fun initViewPager() {
        binding.mainAVp2.adapter = HomeBannerAdapter(requireContext(), imageArray)

    }

    //자동전환을 위해 추가한 부분
    private fun setPage() {
        if (currentPosition == 4)
            currentPosition = 0
        binding.mainAVp2.setCurrentItem(currentPosition, true)
        currentPosition += 1
    }

    inner class pagerRunnable : Runnable {
        override fun run() {
            while (true) {
                Thread.sleep(2000)
                handler.sendEmptyMessage(0)
            }
        }

    }

}