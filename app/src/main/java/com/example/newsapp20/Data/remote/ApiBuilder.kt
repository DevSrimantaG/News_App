package com.example.newsapp20.Data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {
    fun provideApi(): ApiService {
       return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
           .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }
}