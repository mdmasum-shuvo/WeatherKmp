package com.example.weatherkmp.location

interface LocationController {
    suspend fun getCurrentLocation(): Location?
}

data class Location(val latitude: Double, val longitude: Double)