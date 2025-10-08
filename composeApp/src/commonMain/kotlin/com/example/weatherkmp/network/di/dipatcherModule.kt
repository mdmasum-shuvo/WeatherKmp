package com.example.weatherkmp.network.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


val dispatchersModule = module {
    single { providesIODispatcher() }
    single { providesDefaultDispatcher() }
}

fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.Main

fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
