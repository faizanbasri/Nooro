package com.nooro.presentation.features.home

import com.nooro.domain.presentation.models.home.UIWeather
import javax.annotation.concurrent.Immutable

@Immutable
data class HomeState(
    val isLoading: Boolean = false,
    val weatherData: UIWeather? = null
)