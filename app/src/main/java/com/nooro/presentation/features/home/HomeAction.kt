package com.nooro.presentation.features.home


sealed interface HomeAction {
    data class OnSearchWeather(val locationName: String) : HomeAction
}