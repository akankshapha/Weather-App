package com.weather.weatherapplication.service;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherapplication.Exception.WeatherException;
import com.weather.weatherapplication.dao.AuditLogRepository;
import com.weather.weatherapplication.dao.WeatherRepository;
import com.weather.weatherapplication.entity.AuditLog;
import com.weather.weatherapplication.entity.Weather;
import com.weather.weatherapplication.entity.WeatherDataResponse;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WeatherRepository weatherRepository;
	
	@Autowired
	AuditLogRepository auditLogRepo;

	@Value("${openweather.api.key}")
	private String apiKey;
	
	@Cacheable(key = "#cityName", value = "weatherData")
	
	@Override
	public Weather weatherData(String cityName) throws Exception{
		
		System.out.println("weather API");
		
	    String apiUrl = "http://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+cityName+"&aqi=no";
	    
	    AuditLog auditLogRequest = new AuditLog();
	        
	        try {
	        	
	        	ResponseEntity<WeatherDataResponse> responseEntity = restTemplate.exchange(
	            apiUrl,
	            HttpMethod.GET,
	            null,
	            WeatherDataResponse.class
	        	);
	        	
	        if (responseEntity.getStatusCode() == HttpStatus.OK) 
	        {
	            WeatherDataResponse responseBody = responseEntity.getBody();
	            Weather weatherData = new Weather();
	            weatherData.setCity(responseBody.getLocation().getName());
	            weatherData.setTemperature(responseBody.getCurrent().getTemp_c());
	            weatherData.setHumidity(responseBody.getCurrent().getHumidity());

	            Weather response = this.weatherRepository.save(weatherData);
	            auditLogRequest.setAction(apiUrl);
	            auditLogRequest.setResponseBody(responseBody);
	            auditLogRequest.setStatus(responseEntity.getStatusCodeValue());
	            auditLogRepo.save(auditLogRequest);
	            
	            return response;
	        }
	        else {
	        	   return null;
	        }
	        
	        }
	        
	        catch(Exception e)
	        {
	        	auditLogRequest.setAction(apiUrl);
	        	auditLogRequest.setStatus(200);
	        	auditLogRequest.setErrorCode("Invalid City");
	        	auditLogRequest.setCreatedAt(new Timestamp(System.currentTimeMillis()));	       
	            auditLogRepo.save(auditLogRequest);

	        	throw new WeatherException(e.getMessage());
	        	
	        }      
	    }
	}


