package com.example.weatherkmp.data.data_object_model

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherDto(
    val temp: Double?=20.21,
    val feelLike: Double?=24.21,
    val description: String?="Broken Cloud",
    val icon: String?
)
