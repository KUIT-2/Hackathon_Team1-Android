package com.example.hackathon_team1_android

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon_team1_android.databinding.ItemReserveTimeListBinding

class ReserveTimeAdapter(val timeList: ArrayList<String>) :
    RecyclerView.Adapter<ReserveTimeAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(time: String)
    }

    inner class ViewHolder(val binding: ItemReserveTimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(time: String) {
            binding.itemRTTvTime.text = time

            binding.itemRTConstraintLayout.setOnClickListener {
                itemClickListener.onItemClick(time)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var binding =
            ItemReserveTimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReserveTimeAdapter.ViewHolder, position: Int) {
        holder.bind(timeList[position])
    }

    override fun getItemCount(): Int = timeList.size
}