package com.weather.weatherapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.weather.weatherapplication.entity.Weather;
import com.weather.weatherapplication.service.AuditLogService;
import com.weather.weatherapplication.service.WeatherService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class WeatherController {

	 @Autowired
	 private WeatherService weatherService;

	 @Autowired
	 private AuditLogService auditlogservice;
	 
	    
	 @GetMapping("/weather/{cityName}")
	 public ResponseEntity<?> fetchWeatherAndSave(@PathVariable String cityName)  throws Exception
	 {
	      Weather weatherData = weatherService.weatherData(cityName);
	      if (weatherData != null) 
	      {
	        System.out.println("City Name: "+weatherData.getCity());
	        System.out.println("Humidity: "+weatherData.getHumidity());
	        System.out.println("Temperature: "+weatherData.getTemperature());
	        return ResponseEntity.ok("Weather data for " + cityName + " saved successfully.");
	      } 
	      
	      else 
	      {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch weather data.");
	      }
	        
	}    	
	    	
}

