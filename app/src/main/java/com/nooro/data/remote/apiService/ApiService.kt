package com.nooro.data.remote.apiService

import com.nooro.data.remote.endPoints.EndPoints.CURRENT_WEATHER
import com.nooro.data.remote.keys.Keys.QUERY_API
import com.nooro.data.remote.keys.Keys.QUERY_KEY
import com.nooro.data.remote.keys.Keys.QUERY_LOCATION
import com.nooro.domain.remote.models.home.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(CURRENT_WEATHER)
    suspend fun getWeatherData(
        @Query(QUERY_KEY) key: String,
        @Query(QUERY_LOCATION) location: String,
        @Query(QUERY_API) api: String,
    ): Response<WeatherResponse>
}