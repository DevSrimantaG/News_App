package com.example.newsapp20.ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.newsapp20.ui_layer.Home_Screen.HomeScreen
import com.example.newsapp20.ui_layer.Single_News.SingleNews
import com.example.newsapp20.ui_layer.View_Model.viewModel

@Composable
fun NavHostController(VM:viewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenRout) {
        composable<HomeScreenRout> {
            HomeScreen(viewModel = VM,navController = navController)
        }
        composable<SingleNewsRout> {
            val news : SingleNewsRout = it.toRoute()
            SingleNews(
                title = news.title,
                desp = news.desp,
                imageUrl = news.imageUrl,
                dateAndTime = news.dateAndTime,
                newsUrl = news.newsUrl,
                navController = navController
            )
        }
    }
}