package com.mviktorcomposeexample.data.repository

import com.mviktorcomposeexample.data.remote.api.NewsService
import com.mviktorcomposeexample.data.remote.dto.NewsResponse
import com.mviktorcomposeexample.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsService: NewsService
) : NewsRepository {

    override suspend fun fetchNews(country: String, category: String, forceRefresh: Boolean): List<NewsResponse.Article> {
        return newsService.fetchNews(country, category)
    }
}