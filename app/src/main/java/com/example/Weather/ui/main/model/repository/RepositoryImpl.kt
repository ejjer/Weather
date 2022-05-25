package com.example.Weather.ui.main.model.repository

import com.example.Weather.ui.main.model.repository.entities.Weather

class RepositoryImpl: Repository {
    override fun getWeatherFromServer() = Weather()
    override fun getWeatherFromLocalStorage() = Weather()
    }
