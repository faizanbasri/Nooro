package com.nooro.domain.remote.models.home

data class WeatherState(
    val temp_c: Float?,
    val uv: Float?,
    val feelslike_c: Float?,
    val humidity: Int?,
    val condition: WeatherCondition?
)
