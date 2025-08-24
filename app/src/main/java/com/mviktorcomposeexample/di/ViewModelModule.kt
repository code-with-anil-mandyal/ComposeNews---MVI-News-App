package com.mviktorcomposeexample.di

import com.mviktorcomposeexample.presentation.screen.home.HomeScreenVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenVM(get())}
}