package com.yoohyun.sample.di

import com.yoohyun.data.api.OpenWeatherMapApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOpenWeatherMapApi(): OpenWeatherMapApi {
        return OpenWeatherMapApi.create("https://api.openweathermap.org")
    }
}