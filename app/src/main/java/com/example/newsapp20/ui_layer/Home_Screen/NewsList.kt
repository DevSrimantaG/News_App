package com.example.newsapp20.ui_layer.Home_Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.example.newsapp20.R
import com.example.newsapp20.ui_layer.View_Model.viewModel

@Composable
fun NewsList(VM:viewModel) {

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
            if (VM.data.value != null) {
                items(VM.data.value!!.articles){news->
                    Spacer(modifier = Modifier.height(5.dp))
                    Spacer(modifier = Modifier
                        .fillParentMaxWidth()
                        .height(2.dp)
                        .background(Color.Gray))
                    Spacer(modifier = Modifier.height(5.dp))

                    Row (
                        modifier = Modifier.fillParentMaxWidth()
                    ){
                        Column(
                            modifier = Modifier
                                .fillParentMaxWidth(0.45f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            SubcomposeAsyncImage(model =news.urlToImage ?: R.drawable.no_image, 
                                contentDescription =null, 
                                modifier = Modifier.fillMaxWidth(), )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Column (
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(
                                text =news.title ?:"No Title",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 3
                                )
                            Text(text = news.publishedAt, color = Color.Green)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }else{
                item {
                    Column (
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        CircularProgressIndicator()

                    }

                }
            }
        }

    }
}