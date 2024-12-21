package com.nooro.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nooro.data.local.dao.HomeDao
import com.nooro.domain.local.models.home.WeatherData

@Database(entities = [WeatherData::class], version = 1, exportSchema = false)
abstract class NooroDatabase: RoomDatabase() {
    abstract fun homeDao(): HomeDao
}