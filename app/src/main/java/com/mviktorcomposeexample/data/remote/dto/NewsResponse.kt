package com.mviktorcomposeexample.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("articles")
    val articles: List<Article>? = emptyList(),
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int?=null
) {
    @Serializable
    data class Article(
        @SerialName("description")
        val description: String?,
        @SerialName("publishedAt")
        val publishedAt: String,
        @SerialName("title")
        val title: String,
        @SerialName("urlToImage")
        val urlToImage: String?,
        @SerialName("url")
        val url: String?
    )
}