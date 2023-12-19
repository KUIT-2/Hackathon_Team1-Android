package com.example.hackathon_team1_android

import android.content.Context
import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon_team1_android.databinding.FragmentHomeBinding
import com.example.hackathon_team1_android.databinding.ItemHomeViewpager2Binding

class HomeBannerAdapter(val context: Context, val images: List<Int>) :
    RecyclerView.Adapter<HomeBannerAdapter.ViewHolder>() {


    inner class ViewHolder(var binding: ItemHomeViewpager2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(img: Int) {
            binding.itemImageForHomeViewpager2.setImageResource(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeViewpager2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = Int.MAX_VALUE
    //Int.MAX_VALUE
    //Int = images.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position % images.size])
    }
}