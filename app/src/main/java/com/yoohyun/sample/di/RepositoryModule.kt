package com.yoohyun.sample.di

import com.yoohyun.data.api.OpenWeatherMapApi
import com.yoohyun.data.repository.OpenWeatherMapRepositoryImpl
import com.yoohyun.domain.repository.OpenWeatherMapRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideOpenWeatherMapRepository(openWeatherMapApi: OpenWeatherMapApi): OpenWeatherMapRepository =
        OpenWeatherMapRepositoryImpl(openWeatherMapApi)
}