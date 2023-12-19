package com.example.hackathon_team1_android

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon_team1_android.databinding.ItemRestaurantListBinding

class RestaurantAdatper(val restaurantList: ArrayList<DataRestaurant>) :
    RecyclerView.Adapter<RestaurantAdatper.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(res: DataRestaurant)
    }

    inner class ViewHolder(val binding: ItemRestaurantListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(res: DataRestaurant) {
            // 각각의 리사이클러뷰 아이템에 데이터 할당
            binding.itemRLTvTitle.text = res.title // 가게명
            binding.itemRLTvInfo.text = res.info // 가게 정보(설명글)
            binding.itemRLTvCategory.text = res.category // 가게 카테고리
            binding.itemRLTvLocation.text = res.location // 가게 위치

            // 각각의 리사이클러뷰 아이템 클릭 시
            binding.itemRLConstraintLayout.setOnClickListener {
                itemClickListener.onItemClick(res)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            ItemRestaurantListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = restaurantList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }


}