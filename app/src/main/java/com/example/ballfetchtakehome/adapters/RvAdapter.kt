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
    return fetchList.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int){
    val currentItem = fetchList[position]
    holder.binding.apply{
      tvId.text = "Id: ${currentItem.id}"
      tvListId.text = "List Id: ${currentItem.listId}"
      tvName.text = "Name: ${currentItem.name}"
    }
  }
}