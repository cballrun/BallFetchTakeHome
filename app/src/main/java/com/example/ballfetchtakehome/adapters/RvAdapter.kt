package com.example.ballfetchtakehome.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ballfetchtakehome.databinding.ItemLayoutBinding
import com.example.ballfetchtakehome.models.FetchItem

class RvAdapter (private val fetchList: List<FetchItem>): RecyclerView.Adapter<RvAdapter.ViewHolder>(){
  inner class ViewHolder(val binding: ItemLayoutBinding) :
      RecyclerView.ViewHolder(binding.root){

      }

  override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): ViewHolder{
    return ViewHolder(
      ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun getItemCount(): Int {
    TODO("Not yet implemented")
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int){

  }
}