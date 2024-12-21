package com.nooro.domain.presentation.mapper

import com.nooro.domain.local.models.home.WeatherData
import com.nooro.domain.presentation.models.home.UIWeather

fun WeatherData.toUIWeather(): UIWeather {
    return UIWeather(
        locationName = locationName,
        weatherIcon = weatherIcon,
        weatherText = weatherText,
        weatherTemp = weatherTemp,
        weatherHumidity = weatherHumidity,
        weatherUv = weatherUv,
        weatherFeelLike = weatherFeelLike,
    )
}