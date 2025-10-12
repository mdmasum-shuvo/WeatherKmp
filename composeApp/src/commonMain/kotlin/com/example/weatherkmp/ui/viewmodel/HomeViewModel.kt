package com.example.weatherkmp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherkmp.network.data_object_model.WeatherDto
import com.example.weatherkmp.network.remote_data.api_use_case.WeatherApiUseCase
import com.example.weatherkmp.network.state.CommonUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel (private val weatherApiUseCase: WeatherApiUseCase)  : ViewModel() {
    private var _uiState = MutableStateFlow(CommonUiState())
    val uiState=_uiState.asStateFlow()
    private var _weatherData= MutableStateFlow<WeatherDto?>(null)

    val weatherData=_weatherData.asStateFlow()
    init {
        fetchWeatherData(23.780424, 90.415921)
    }


    fun fetchWeatherData(lat: Double, lng: Double) {
        _uiState.value = CommonUiState(isLoading = true)
        viewModelScope.launch {
            val weatherApiUseCase = weatherApiUseCase(
                lat, lng
            )
            weatherApiUseCase.onSuccess {
                _weatherData.value = it
                _uiState.value = CommonUiState(success = true)
            }
            weatherApiUseCase.onFailure {
                _uiState.value = CommonUiState(error = "No Weather Data found")
            }
        }
    }



}