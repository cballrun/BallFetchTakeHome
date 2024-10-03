package com.example.ballfetchtakehome.models

sealed class ListItem {
  data class Header(val listId: Int) : ListItem()
  data class Item(val fetchItem: FetchItem) : ListItem()
}