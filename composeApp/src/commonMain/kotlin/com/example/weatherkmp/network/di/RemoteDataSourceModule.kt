package com.example.weatherkmp.network.di

import com.example.weatherkmp.network.remote_data.data_source.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { RemoteDataSource(KtorHttpClient().get()) }

}
