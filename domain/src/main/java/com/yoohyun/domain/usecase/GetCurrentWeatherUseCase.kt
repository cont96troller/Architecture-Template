package com.yoohyun.domain.usecase

import com.yoohyun.domain.model.CurrentWeather
import com.yoohyun.domain.repository.OpenWeatherMapRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherMapRepository: OpenWeatherMapRepository
) : FlowUseCase<GetCurrentWeatherUseCaseParams, CurrentWeather>() {
    override fun execute(parameters: GetCurrentWeatherUseCaseParams): Flow<CurrentWeather> {
        return weatherMapRepository.getCurrentWeather(
            parameters.lat,
            parameters.lon,
            "api key"
        )
    }
}

data class GetCurrentWeatherUseCaseParams(val lat: Double, val lon: Double)