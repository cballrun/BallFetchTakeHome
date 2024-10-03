package com.example.ballfetchtakehome.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ballfetchtakehome.databinding.ItemLayoutBinding

class RvAdapter {
  inner class ViewHolder(val binding: ItemLayoutBinding) :
      RecyclerView.ViewHolder(binding.root){

      }

  fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): ViewHolder{
    return ViewHolder(
      ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }
}