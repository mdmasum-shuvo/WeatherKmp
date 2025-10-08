package com.example.weatherkmp.network.remote_data.repository

import com.example.weatherkmp.network.data_object_model.WeatherDto


interface NetworkDataRepository {

    suspend fun getWeatherData(lat: Double, lnf: Double): Result<WeatherDto>

}