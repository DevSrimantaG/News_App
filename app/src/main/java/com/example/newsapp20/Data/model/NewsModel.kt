package com.example.newsapp20.Data.model

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)