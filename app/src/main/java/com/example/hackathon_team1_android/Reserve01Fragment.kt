package com.example.hackathon_team1_android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon_team1_android.databinding.FragmentReserve01Binding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView


class Reserve01Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentReserve01Binding
    private var timeList: ArrayList<String> = arrayListOf()
    private var reserveTimeAdapter: ReserveTimeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReserve01Binding.inflate(inflater, container, false)

        // CalendarView
        val calendarView: MaterialCalendarView = binding.reserve01FCalendar
        val selectedDate = CalendarDay.today()
        calendarView.setSelectedDate(selectedDate)

        val radioGroup = binding.reserve01FRadiogroupPerson as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // checkedId를 사용하여 어떤 RadioButton이 체크되었는지 처리
//            val reserve02Fragment = Reserve02Fragment().apply {
//                arguments = Bundle().apply {
//                    putInt("personKey", checkedId)
//                }
//            }
        }

        initReserveTime()
        initRecyclerView()

        binding.reserve01FBtnClose.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            val bottomSheetInternal =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheetInternal?.let {
                val layoutParams = it.layoutParams
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                it.layoutParams = layoutParams
                BottomSheetBehavior.from(it).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }


    }

    private fun initReserveTime() {
        timeList.addAll(
            arrayListOf(
                "오후 6:00",
                "오후 6:30",
                "오후 7:00",
                "오후 7:30",
                "오후 8:00"
            )
        )
    }

    private fun initRecyclerView() {
        reserveTimeAdapter = ReserveTimeAdapter(timeList)
        binding.reserve01FTimeList.adapter = reserveTimeAdapter
        binding.reserve01FTimeList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        reserveTimeAdapter?.setOnItemClickListener(object :
            ReserveTimeAdapter.OnItemClickListener {
            override fun onItemClick(time: String) {

                val reserve02Fragment = Reserve02Fragment().apply {
                    arguments = Bundle().apply {
                        putString("timeKey", time)
                    }
                }

                dismiss()
                (requireActivity() as RestaurantActivity).showReserve02Fragment(reserve02Fragment)
            }
        })
    }


}
