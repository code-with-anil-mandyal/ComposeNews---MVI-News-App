package com.mviktorcomposeexample.domain.usecase


import com.mviktorcomposeexample.common.utils.DateUtils.getDaysAgoString
import com.mviktorcomposeexample.data.mapper.NewsMapper.mapArticles
import com.mviktorcomposeexample.domain.model.News
import com.mviktorcomposeexample.data.remote.dto.NewsResponse
import com.mviktorcomposeexample.domain.repository.NewsRepository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant


class NewsUseCase(
    private val repository: NewsRepository
) {

    suspend fun getArticles(
        country: String, category: String, forceRefresh: Boolean = false
    ): List<News>{
        val articlesRaw = repository.fetchNews(country, category, forceRefresh)
        return mapArticles(articlesRaw)
    }




}