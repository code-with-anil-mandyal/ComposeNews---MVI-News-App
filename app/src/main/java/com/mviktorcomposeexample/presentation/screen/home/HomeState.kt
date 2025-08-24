package com.mviktorcomposeexample.presentation.screen.home

import com.mviktorcomposeexample.domain.model.News

data class HomeState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val newsList: List<News> = emptyList(),
    val error: String? = null,
    val selectedNewsUrl: String? = null
)