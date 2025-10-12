package com.example.weatherkmp.di

import com.example.weatherkmp.network.di.dispatchersModule
import com.example.weatherkmp.network.di.remoteDataSourceModule
import com.example.weatherkmp.network.di.remoteRepositoryModule
import org.koin.dsl.module


val appModule = module {
    includes(remoteDataSourceModule, remoteRepositoryModule, dispatchersModule,viewModelModule)
}