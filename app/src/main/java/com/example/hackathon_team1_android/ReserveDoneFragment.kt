package com.example.hackathon_team1_android

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathon_team1_android.databinding.FragmentReserveDoneBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ReserveDoneFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentReserveDoneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReserveDoneBinding.inflate(inflater, container, false)

        binding.reserveDoneFBtnCancel.setOnClickListener {
            // mainActivity로 이동하기
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().finish() // 현재 액티비티를 종료
        }

        return binding.root
    }
}