package com.example.Weather.ui.main.model.repository

import com.example.Weather.ui.main.model.repository.entities.Weather

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
}