package com.example.weatherkmp.network.di

import com.example.weatherkmp.network.remote_data.api_use_case.WeatherApiUseCase
import com.example.weatherkmp.network.remote_data.api_use_case.WeatherApiUseCaseImpl
import com.example.weatherkmp.network.remote_data.repository.NetworkDataRepository
import com.example.weatherkmp.network.remote_data.repository.RemoteRepositoryImpl
import org.koin.dsl.module

val remoteRepositoryModule = module {
    single<NetworkDataRepository> { RemoteRepositoryImpl(get()) }
    single<WeatherApiUseCase> { WeatherApiUseCaseImpl(get()) }
    //single { NetworkCheckerUtils(get()) }
  //  single { NetworkCheckerRepository(get()) }

}