package com.example.hackathon_team1_android.ui.home

import android.content.Intent
import android.os.Bundle
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

    val imageArray = listOf(
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

        binding.mainAIvDetailMenu2.setOnClickListener {
            val intent = Intent(requireContext(), RestaurantListActivity::class.java)
            startActivity(intent)
        }

        return binding.root

    }

    private fun initViewPager() {
        binding.mainAVp2.adapter = HomeBannerAdapter(requireContext(), imageArray)
    }

}