package com.nooro.domain.presentation.models.home

data class UIWeather(
    val locationName: String?,
    val weatherIcon: String?,
    val weatherText: String?,
    val weatherTemp: Float?,
    val weatherHumidity: Int?,
    val weatherUv: Float?,
    val weatherFeelLike: Float?,
)
