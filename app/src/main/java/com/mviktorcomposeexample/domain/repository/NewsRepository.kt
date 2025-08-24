package com.mviktorcomposeexample.domain.repository

import com.mviktorcomposeexample.data.remote.dto.NewsResponse

interface NewsRepository {
    suspend fun fetchNews(country: String, category: String, forceRefresh: Boolean): List<NewsResponse.Article>
}