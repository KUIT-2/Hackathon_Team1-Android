package com.example.hackathon_team1_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathon_team1_android.databinding.FragmentReserve02Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Reserve02Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentReserve02Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReserve02Binding.inflate(inflater, container, false)

        binding.reserve02FBtnCancel.setOnClickListener {
            dismiss()
        }

        binding.reserve02FBtnOk.setOnClickListener {
            dismiss()
            (requireActivity() as RestaurantActivity).showReserveCheckFragment()
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reserveTime = arguments?.getString("timeKey")
//        val reservePerson = arguments?.getInt("personKey")
//        Log.d("keyeky", reservePerson.toString())

        binding.reserve02FTvTime.text = reserveTime
//        binding.reserve02FTvPerson.text = reservePerson.toString() + "명"

    }
}