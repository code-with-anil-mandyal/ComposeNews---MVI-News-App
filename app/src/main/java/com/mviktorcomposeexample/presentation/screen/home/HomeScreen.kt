package com.mviktorcomposeexample.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mviktorcomposeexample.presentation.components.CustomAppBar
import com.mviktorcomposeexample.presentation.components.ErrorMessage
import com.mviktorcomposeexample.presentation.components.Loader
import com.mviktorcomposeexample.presentation.components.NewsItem
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(onArticlesClick : (String) -> Unit,
               homeScreenVM: HomeScreenVM = getViewModel(),
               onChangeTheme: () -> Unit
){
    val homeState = homeScreenVM.newsState.collectAsState()


    Column {
        // Toggle Button
        Button(onClick = { onChangeTheme() }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Change Theme")
        }
        if(homeState.value.isLoading)
            Loader()
        if(homeState.value.error != null)
            ErrorMessage(homeState.value.error)
        if(homeState.value.newsList.isNotEmpty())
            NewsListView(homeScreenVM = homeScreenVM,
                onNewsClick = { url ->
                        homeScreenVM.handleIntent(HomeIntent.SelectNews(url))
                        onArticlesClick(url)
                })
    }
}

@Composable
fun NewsListView(
    homeScreenVM: HomeScreenVM,
    onNewsClick: (String) -> Unit
) {
    val homeState = homeScreenVM.newsState.collectAsState()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = homeState.value.isRefreshing),
        onRefresh = { homeScreenVM.handleIntent(HomeIntent.RefreshNews) }
    ) {
        LazyColumn {
            items(homeState.value.newsList) { news ->
                NewsItem(news) {
                    homeScreenVM.handleIntent(HomeIntent.SelectNews(news.url))
                    onNewsClick(news.url)
                }
            }
        }
    }
}