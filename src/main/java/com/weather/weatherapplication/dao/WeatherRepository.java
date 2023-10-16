package com.weather.weatherapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weather.weatherapplication.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
