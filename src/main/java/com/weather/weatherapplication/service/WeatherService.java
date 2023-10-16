package com.weather.weatherapplication.service;

import com.weather.weatherapplication.entity.Weather;

public interface WeatherService {

	Weather weatherData(String cityName) throws Exception;
}
