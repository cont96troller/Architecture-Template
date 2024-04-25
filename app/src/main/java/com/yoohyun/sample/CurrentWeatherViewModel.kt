package com.yoohyun.sample

import androidx.lifecycle.ViewModel
import com.yoohyun.domain.usecase.GetCurrentWeatherUseCase
import javax.inject.Inject

class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {
}