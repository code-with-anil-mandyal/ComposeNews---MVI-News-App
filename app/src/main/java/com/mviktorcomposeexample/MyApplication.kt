package com.mviktorcomposeexample

import android.app.Application
import com.mviktorcomposeexample.di.apiModules
import com.mviktorcomposeexample.di.networkModule
import com.mviktorcomposeexample.di.repositoryModule
import com.mviktorcomposeexample.di.useCaseModule
import com.mviktorcomposeexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = apiModules + networkModule + viewModelModule + repositoryModule + useCaseModule
        startKoin {
            androidContext(this@MyApplication)
            modules(modules)
        }
    }

}
