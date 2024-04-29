package com.yoohyun.data.repository

import com.yoohyun.data.BuildConfig
import com.yoohyun.data.api.OpenWeatherMapApi
import com.yoohyun.data.model.CurrentWeatherResponse
import com.yoohyun.domain.model.CurrentWeather
import com.yoohyun.domain.repository.OpenWeatherMapRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenWeatherMapRepositoryImpl(private val api: OpenWeatherMapApi) : OpenWeatherMapRepository {
    override fun getCurrentWeather(
        lat: Double,
        lon: Double,
        apiKey: String
    ): Flow<CurrentWeather> {
        return flow {
            val apiResult: CurrentWeatherResponse =
                api.getCurrentWeather(lat, lon, apiKey = BuildConfig.WEATHER_API_KEY)
            val description = apiResult.weather.first().description
            emit(CurrentWeather(description = description))
        }
    }
}