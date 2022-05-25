package com.example.Weather.ui.main.model.repository.entities

data class Weather( val city:City = getDefaultCity(), val temperature: Int = 0, val feelLike: Int = 0 )

    fun getDefaultCity() = City("Москва", 55.755826,37.617299900000035)
