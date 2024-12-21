package com.nooro.di

import android.content.Context
import androidx.room.Room
import com.nooro.data.local.database.NooroDatabase
import com.nooro.data.local.dao.HomeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NooroDatabase {
        return Room.databaseBuilder(
            context,
            NooroDatabase::class.java,
            "nooro_test_app_db"
        ).build()
    }

    @Provides
    fun provideHomeDao(database: NooroDatabase): HomeDao {
        return database.homeDao()
    }
}