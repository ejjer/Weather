package com.example.Weather.ui.main.model.repository

import com.example.Weather.ui.main.model.repository.entities.Weather

sealed class AppState{
    data class Success(val weatherData:Weather): AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()

}
