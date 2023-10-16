package com.weather.weatherapplication.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.weather.weatherapplication.entity.WeatherDataResponse;
import com.weather.weatherapplication.entity.WeatherDataResponse.Current;
import com.weather.weatherapplication.entity.WeatherDataResponse.Location;

@SpringBootTest
public class WeatherDataResponseTest {

	@Test
	public void testWeatherDAtaResponseGettterAndSetter() {
		WeatherDataResponse response = new WeatherDataResponse();
		Location location = new Location();
		
		location.setName("Pune");
		response.setLocation(location);
		
		Current current =new Current();
		current.setTemp_c(11.0);
		current.setHumidity(22.0);
		
		response.setCurrent(current);
		assertEquals(location,response.getLocation());
		assertEquals(current,response.getCurrent());
		
		
		}
	
}
