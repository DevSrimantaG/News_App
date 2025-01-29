package com.example.newsapp20.ui_layer.View_Model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp20.Data.model.NewsModel
import com.example.newsapp20.Data.remote.ApiBuilder
import com.example.newsapp20.Data.remote.ApiBuilder.provideApi
import kotlinx.coroutines.launch

class viewModel:ViewModel() {

    var data = mutableStateOf<NewsModel?>(null)

   fun getTopNews(category: String?){
       viewModelScope.launch {
           if (category == null){
               data.value = provideApi().getTopHeadlines()
           }
           else{
               data.value = provideApi().getCategoryNews(category = "business")
           }
       }
   }
}