package com.mviktorcomposeexample.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mviktorcomposeexample.domain.usecase.NewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenVM(
    private val useCase: NewsUseCase
): ViewModel() {
    private val _newsState : MutableStateFlow<HomeState> = MutableStateFlow(
        HomeState(
            isLoading = true
        )
    )
    val newsState : StateFlow<HomeState> get() = _newsState


    init {
        //getArticles(ApiKeys.COUNTRY, ApiKeys.CATEGORY)
        handleIntent(HomeIntent.LoadNews)
    }


    fun handleIntent(intent: HomeIntent){
        when(intent){
            is HomeIntent.LoadNews -> getArticles("us", "business")
            is HomeIntent.RefreshNews -> getArticles("us", "business", isRefresh = true)
            is HomeIntent.SelectNews -> selectNews(intent.sourceUrl)
        }
    }

    private fun selectNews(url: String) {
        viewModelScope.launch {
            _newsState.emit(
                _newsState.value.copy(
                    selectedNewsUrl = url
                )
            )
        }
    }




    private fun getArticles(
        country: String,
        category: String,
        isRefresh: Boolean = false
    ) {
        viewModelScope.launch {
            _newsState.emit(
                _newsState.value.copy(
                    isLoading = !isRefresh, // show loading spinner only for first load
                    isRefreshing = isRefresh, // special flag for swipe refresh
                    error = null
                )
            )

            try {
                val fetchedArticles = useCase.getArticles(
                    country = country,
                    category = category,
                    forceRefresh = isRefresh
                )
                _newsState.emit(
                    HomeState(
                        newsList = fetchedArticles,
                        isLoading = false,
                        isRefreshing = false
                    )
                )
            } catch (e: Exception) {
                _newsState.emit(
                    _newsState.value.copy(
                        error = e.localizedMessage,
                        isLoading = false,
                        isRefreshing = false
                    )
                )
            }
        }
    }

}