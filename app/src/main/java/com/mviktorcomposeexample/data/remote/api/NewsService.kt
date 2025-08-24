package com.mviktorcomposeexample.data.remote.api

import com.mviktorcomposeexample.data.remote.api.ApiKeys.TOP_HEADLINES
import com.mviktorcomposeexample.data.remote.dto.NewsResponse
import io.ktor.client.HttpClient

class NewsService(httpClient: HttpClient):BaseApiService(httpClient) {

    suspend fun fetchNews(
        country: String,
        category: String
    ): List<NewsResponse.Article> {
        val response: NewsResponse = getRequest(
            endpoint = TOP_HEADLINES,
            queryParams = mapOf(
                "country" to country,
                "category" to category
            )
        )
        return response.articles?:emptyList()
    }

}