package com.weather.weatherapplication.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.weather.weatherapplication.entity.Weather;
import com.weather.weatherapplication.service.AuditLogService;
import com.weather.weatherapplication.service.WeatherService;



@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {


	@Autowired
     private MockMvc mockMvc;

	
		 @MockBean
		 private WeatherService weatherService;

		@MockBean
		private AuditLogService auditlogservice;

		 @Test
		    public void testgetWeatherData() throws Exception {
			 
		        String cityName = "New York";
		        Weather weatherData = new Weather();
		        weatherData.setCity("New York");
		        weatherData.setHumidity(50);
		        weatherData.setTemperature(72);
		        Mockito.when(weatherService.weatherData(cityName)).thenReturn(weatherData);
		        mockMvc.perform(get("/weather/{cityName}", cityName))
		            .andExpect(status().isOk())
		            .andExpect(content().string("Weather data for " + cityName + " saved successfully."));
		    
		        verify(weatherService, times(1)).weatherData(cityName);

		 

		 }
		 @Test
		 	public void testFetchWeatherAndSaveFailure() throws Exception {
		    String cityName = "NonExistentCity";
		    when(weatherService.weatherData(cityName)).thenReturn(null);

	 

		    mockMvc.perform(get("/weather/{cityName}", cityName))

		    .andExpect(status().isInternalServerError())

		    .andExpect(content().string("Failed to fetch weather data."));

		    

		    verify(weatherService, times(1)).weatherData(cityName);

		   

		 	}

	
}
