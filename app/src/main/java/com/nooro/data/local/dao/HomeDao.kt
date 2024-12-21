package com.nooro.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nooro.domain.local.models.home.WeatherData

@Dao
interface HomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(weatherData: WeatherData)

    @Query("SELECT * FROM weather_table")
    suspend fun getWeatherData(): WeatherData?

    @Query("DELETE FROM weather_table")
    suspend fun clearWeatherData()
}