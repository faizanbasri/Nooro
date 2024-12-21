package com.nooro.data.repository.home


import com.nooro.core.networkUtils.NetworkError
import com.nooro.core.networkUtils.Result
import com.nooro.domain.presentation.models.home.UIWeather

interface HomeRepository {
    suspend fun getSavedWeather(): Result<UIWeather, NetworkError>

    suspend fun searchWeather(locationName: String): Result<UIWeather, NetworkError>
}