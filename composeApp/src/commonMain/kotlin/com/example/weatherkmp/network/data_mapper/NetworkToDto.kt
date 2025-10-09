package com.example.weatherkmp.network.data_mapper

import com.example.weatherkmp.network.data_object_model.WeatherDto
import com.example.weatherkmp.network.remote_data.model.weather.WeatherResponse
import com.example.weatherkmp.util.WeatherUtils


fun WeatherResponse.toDto(): WeatherDto {

    return WeatherDto(
        temp = main?.temp ?: 0.0,
        feelLike = main?.feelsLike,
        description = weather?.get(0)?.description,
        icon = WeatherUtils.getIconUrl(weather?.get(0)?.icon ?: ""),
    )
}