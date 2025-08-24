package com.mviktorcomposeexample.presentation.screen.home

sealed class HomeIntent {
    object LoadNews : HomeIntent()
    object RefreshNews : HomeIntent()
    data class SelectNews(val sourceUrl: String) : HomeIntent()
}