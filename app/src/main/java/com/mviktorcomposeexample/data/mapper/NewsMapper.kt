package com.mviktorcomposeexample.data.mapper

import com.mviktorcomposeexample.common.utils.DateUtils.getDaysAgoString
import com.mviktorcomposeexample.data.remote.dto.NewsResponse
import com.mviktorcomposeexample.domain.model.News

object NewsMapper {

     fun mapArticles(articlesRaw: List<NewsResponse.Article>): List<News> = articlesRaw.map { article ->
        News(
            article.title,
            article.description ?: "",
            url = article.url?:"",
            article.urlToImage ?: "https://placehold.co/600x400",
            getDaysAgoString(article.publishedAt)
        )
    }

}