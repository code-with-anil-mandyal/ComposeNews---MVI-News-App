package com.mviktorcomposeexample.di

import com.mviktorcomposeexample.data.repository.NewsRepositoryImpl
import com.mviktorcomposeexample.domain.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}