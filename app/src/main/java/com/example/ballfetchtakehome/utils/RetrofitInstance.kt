package com.example.ballfetchtakehome.utils

import com.example.ballfetchtakehome.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
  val api : ApiInterface by lazy {
    Retrofit.Builder()
      .baseUrl(Utils.BASE)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(ApiInterface::class.java)
  }
}