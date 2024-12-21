package com.nooro.domain.local.models.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherData(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val locationName: String?,
    val weatherIcon: String?,
    val weatherText: String?,
    val weatherTemp: Float?,
    val weatherHumidity: Int?,
    val weatherUv: Float?,
    val weatherFeelLike: Float?,
)
