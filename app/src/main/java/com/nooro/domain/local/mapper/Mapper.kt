package com.nooro.domain.local.mapper

import com.nooro.domain.local.models.home.WeatherData
import com.nooro.domain.remote.models.home.WeatherResponse

fun WeatherResponse.toWeatherLocalData(): WeatherData {
    return WeatherData(
        locationName = location?.name,
        weatherIcon = current?.condition?.icon,
        weatherText = current?.condition?.text,
        weatherTemp = current?.temp_c,
        weatherHumidity = current?.humidity,
        weatherUv = current?.uv,
        weatherFeelLike = current?.feelslike_c,
    )
}