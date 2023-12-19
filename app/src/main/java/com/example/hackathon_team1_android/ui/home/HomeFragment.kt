package com.example.hackathon_team1_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackathon_team1_android.HomeBannerAdapter
import com.example.hackathon_team1_android.R
import com.example.hackathon_team1_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(layoutInflater)

        initViewPager()

        return binding.root
    }

    private fun initViewPager() {
        binding.mainAVp2.adapter = HomeBannerAdapter(requireContext(), imageArray)
    }

}