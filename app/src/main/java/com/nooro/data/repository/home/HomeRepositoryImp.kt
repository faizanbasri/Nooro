package com.nooro.data.repository.home

import com.nooro.BuildConfig
import com.nooro.core.networkCall.safeCall
import com.nooro.core.networkUtils.NetworkError
import com.nooro.core.networkUtils.Result
import com.nooro.core.networkUtils.map
import com.nooro.core.networkUtils.onError
import com.nooro.core.networkUtils.onSuccess
import com.nooro.data.local.dao.HomeDao
import com.nooro.data.remote.apiService.ApiService
import com.nooro.domain.local.mapper.toWeatherLocalData
import com.nooro.domain.presentation.mapper.toUIWeather
import com.nooro.domain.presentation.models.home.UIWeather
import com.nooro.domain.remote.models.home.WeatherResponse
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(
    private val apiService: ApiService, private val homeDao: HomeDao
) : HomeRepository {

    override suspend fun getSavedWeather(): Result<UIWeather, NetworkError> {
        val localData = homeDao.getWeatherData()
        if (localData != null) {
            val remoteData = safeCall<WeatherResponse> {
                apiService.getWeatherData(
                    key = BuildConfig.WeatherAPIKey,
                    api = "no",
                    location = localData.locationName ?: ""
                )
            }.map { response ->
                response.toWeatherLocalData()
            }
            remoteData.onSuccess {
                homeDao.clearWeatherData()
                homeDao.insertWeatherData(it)
            }.onError {
                return Result.Error(it)
            }

            val newLocalData = homeDao.getWeatherData()
            return if (newLocalData != null) {
                Result.Success(newLocalData.toUIWeather())
            } else {
                Result.Error(NetworkError.UNKNOWN)
            }
        } else {
            return Result.Error(NetworkError.UNKNOWN)
        }
    }

    override suspend fun searchWeather(locationName: String): Result<UIWeather, NetworkError> {
        val remoteData = safeCall<WeatherResponse> {
            apiService.getWeatherData(
                key = BuildConfig.WeatherAPIKey, api = "no", location = locationName
            )
        }.map { response ->
            response.toWeatherLocalData()
        }
        remoteData.onSuccess {
            homeDao.clearWeatherData()
            homeDao.insertWeatherData(it)
        }.onError {
            return Result.Error(it)
        }
        val localData = homeDao.getWeatherData()
        return if (localData != null) {
            Result.Success(localData.toUIWeather())
        } else {
            Result.Error(NetworkError.UNKNOWN)
        }
    }
}