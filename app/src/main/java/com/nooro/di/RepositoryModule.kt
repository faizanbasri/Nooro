package com.nooro.di

import com.nooro.data.repository.home.HomeRepository
import com.nooro.data.repository.home.HomeRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideHomeRepository(homeRepo: HomeRepositoryImp): HomeRepository = homeRepo

}