package com.yoohyun.domain.repository

import com.yoohyun.domain.model.CurrentWeather
import kotlinx.coroutines.flow.Flow


interface OpenWeatherMapRepository {

    fun getCurrentWeather(lat: Double, lon: Double, apiKey: String): Flow<CurrentWeather>
}