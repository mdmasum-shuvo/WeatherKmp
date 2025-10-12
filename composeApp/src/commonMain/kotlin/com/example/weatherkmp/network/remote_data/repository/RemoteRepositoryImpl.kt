package com.example.weatherkmp.network.remote_data.repository

import com.example.weatherkmp.network.data_mapper.toDto
import com.example.weatherkmp.network.data_object_model.WeatherDto
import com.example.weatherkmp.network.remote_data.data_source.RemoteDataSource
import com.example.weatherkmp.network.remote_data.model.weather.WeatherResponse
import io.ktor.client.call.body
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : NetworkDataRepository {
    override suspend fun getWeatherData(lat: Double, lng: Double): Result<WeatherDto> =
        runCatching {
            remoteDataSource.getWeatherData(lat, lng).body<WeatherResponse>().toDto()
        }

}