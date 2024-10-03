package com.example.ballfetchtakehome

import com.example.ballfetchtakehome.models.Fetch
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
  @GET("/hiring.json")
  suspend fun getAllFetch():Response<Fetch>
}