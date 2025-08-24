package com.mviktorcomposeexample.di

import com.mviktorcomposeexample.data.remote.api.BaseApiService
import com.mviktorcomposeexample.data.remote.api.NewsService
import com.mviktorcomposeexample.domain.usecase.NewsUseCase
import org.koin.dsl.module

val apiModules = module{

    single { BaseApiService(get()) }
    single { NewsService(get()) }


}