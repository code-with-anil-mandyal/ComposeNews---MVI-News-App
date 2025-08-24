package com.mviktorcomposeexample.di

import com.mviktorcomposeexample.domain.usecase.NewsUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { NewsUseCase(get()) }
}