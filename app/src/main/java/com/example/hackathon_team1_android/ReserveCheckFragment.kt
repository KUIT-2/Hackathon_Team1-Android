package com.example.hackathon_team1_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathon_team1_android.databinding.FragmentReserveCheckBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ReserveCheckFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentReserveCheckBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReserveCheckBinding.inflate(inflater, container, false)

        binding.reserveCheckFBtnCancel.setOnClickListener {
            dismiss()
        }

        binding.reserveCheckFBtnOk.setOnClickListener {
            dismiss()
            (requireActivity() as RestaurantActivity).showReserveDoneFragment()
        }

        return binding.root
    }
}