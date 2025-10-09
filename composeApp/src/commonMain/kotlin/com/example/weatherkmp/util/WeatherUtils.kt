package com.example.weatherkmp.util




object WeatherUtils {



    fun getIconUrl(icon: String): String {
        return "https://openweathermap.org/img/wn/${icon}@4x.png"
    }



}