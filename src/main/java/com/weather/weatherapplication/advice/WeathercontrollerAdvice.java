package com.weather.weatherapplication.advice;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;



import com.weather.weatherapplication.Exception.WeatherException;

 

@RestControllerAdvice
public class WeathercontrollerAdvice {

	@ExceptionHandler(WeatherException.class)
	public ResponseEntity<String>handWeatherException(WeatherException weatherException)
	{
		
	return new ResponseEntity<String>(weatherException.getMessage(),HttpStatus.BAD_REQUEST);
	
	}

}