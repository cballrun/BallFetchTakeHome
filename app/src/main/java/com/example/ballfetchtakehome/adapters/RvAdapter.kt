package com.example.ballfetchtakehome.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ballfetchtakehome.databinding.ItemLayoutBinding
import com.example.ballfetchtakehome.databinding.HeaderLayoutBinding
import com.example.ballfetchtakehome.models.FetchItem
import com.example.ballfetchtakehome.models.ListItem

class RvAdapter(private val itemList: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

  companion object {
    private const val VIEW_TYPE_HEADER = 0
    private const val VIEW_TYPE_ITEM = 1
  }

  inner class HeaderViewHolder(val binding: HeaderLayoutBinding) : RecyclerView.ViewHolder(binding.root)

  inner class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

  override fun getItemViewType(position: Int): Int {
    return when (itemList[position]) {
      is ListItem.Header -> VIEW_TYPE_HEADER
      is ListItem.Item -> VIEW_TYPE_ITEM
    }
  }


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
      VIEW_TYPE_HEADER -> {
        val binding = HeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        HeaderViewHolder(binding)
      }
      VIEW_TYPE_ITEM -> {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ItemViewHolder(binding)
      }
      else -> throw IllegalArgumentException("Invalid view type")
    }
  }


  override fun getItemCount(): Int {
    return itemList.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val listItem = itemList[position]
    when (holder) {
      is HeaderViewHolder -> {
        val header = listItem as ListItem.Header
        holder.binding.tvHeader.text = "List ID: ${header.listId}"
      }
      is ItemViewHolder -> {
        val item = listItem as ListItem.Item
        holder.binding.apply {
          tvId.text = "Id: ${item.fetchItem.id}"
          tvListId.text = "List Id: ${item.fetchItem.listId}"
          tvName.text = "Name: ${item.fetchItem.name}"
        }
      }
    }
  }
}