package com.example.newsapp20.Data.remote

import androidx.lifecycle.ViewModel
import com.example.newsapp20.Data.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
   suspend fun getEverythingNews(
       @Query("q") q: String = "tesla",
       @Query("from") from: String = "2024-12-28",
       @Query("sortBy") sortBy: String = "publishedAt",
       @Query("apiKey") apiKey: String = "cccf54d319934db2bb8b035838d21711"
    ): NewsModel
}