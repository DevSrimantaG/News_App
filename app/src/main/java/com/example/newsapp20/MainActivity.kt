package com.example.newsapp20

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.newsapp20.ui.theme.NewsApp20Theme
import com.example.newsapp20.ui_layer.Single_News.SingleNews
import com.example.newsapp20.ui_layer.View_Model.viewModel
import com.example.newsapp20.ui_layer.navigation.NavHostController

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
       val VM by viewModels<viewModel> ()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsApp20Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding

                  NavHostController(VM)

                }
            }
        }
    }
}

