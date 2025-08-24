package com.mviktorcomposeexample.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mviktorcomposeexample.domain.model.News

@Composable
fun NewsItem(news: News, onClick: () -> Unit){
    Column(modifier = Modifier.fillMaxWidth()
        .clickable{
            onClick()
        }
    ) {
        AsyncImage(
            model = news.urlToImage,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = news.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = news.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = news.publishedAt,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Spacer(modifier = Modifier.height(1.dp).background(
            color = Color.Gray
        ))
    }
}