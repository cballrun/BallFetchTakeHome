package com.example.ballfetchtakehome

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ballfetchtakehome.adapters.RvAdapter
import com.example.ballfetchtakehome.databinding.ActivityMainBinding
import com.example.ballfetchtakehome.models.FetchItem
import com.example.ballfetchtakehome.models.ListItem
import com.example.ballfetchtakehome.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private lateinit var rvAdapter: RvAdapter
  private lateinit var fetchList: List<FetchItem>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    enableEdgeToEdge()
    setContentView(binding.root)

    fetchList = listOf()

    GlobalScope.launch(Dispatchers.IO) {
      val response = try {
        RetrofitInstance.api.getAllFetch()
      }catch(e: IOException){
        Toast.makeText(applicationContext, "Application error ${e.message}", Toast.LENGTH_LONG).show()
        return@launch
      }catch(e: HttpException){
        Toast.makeText(applicationContext, "HTTP error ${e.message}", Toast.LENGTH_LONG).show()
        return@launch
      }
      if(response.isSuccessful && response.body() != null) {
        fetchList = response.body()!!
        val filteredFetchList = fetchList.filter{!it.name.isNullOrBlank()}
        val sortedFetchList = filteredFetchList.sortedWith(compareBy<FetchItem> {it.listId}.thenBy{it.name})
        val groupedFetchList = mutableListOf<ListItem>()
        var currentListId = -1

        for(fetchItem in sortedFetchList) {
          if(fetchItem.listId != currentListId) {
            currentListId = fetchItem.listId
            groupedFetchList.add(ListItem.Header(currentListId))
          }
          groupedFetchList.add(ListItem.Item(fetchItem))
        }

        withContext(Dispatchers.Main){
          binding.rvMain.apply{
            rvAdapter = RvAdapter(groupedFetchList)
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
          }
        }
      }
    }

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }
  }
}