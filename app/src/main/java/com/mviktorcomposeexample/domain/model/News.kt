package com.mviktorcomposeexample.domain.model

data class News(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)
