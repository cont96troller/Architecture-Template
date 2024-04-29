package com.yoohyun.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoohyun.data.BuildConfig
import com.yoohyun.domain.model.CurrentWeather
import com.yoohyun.domain.usecase.GetCurrentWeatherUseCase
import com.yoohyun.domain.usecase.GetCurrentWeatherUseCaseParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    private val _currentWeather = MutableStateFlow<CurrentWeather?>(null)
    val currentWeather get() = _currentWeather.asStateFlow()

    fun getCurrentWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            getCurrentWeatherUseCase(
                GetCurrentWeatherUseCaseParams(
                    lat, lon, BuildConfig.WEATHER_API_KEY
                )
            ).collectLatest {
                _currentWeather.value = it
            }
        }
    }

}