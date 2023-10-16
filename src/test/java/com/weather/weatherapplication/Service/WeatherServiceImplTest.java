package com.weather.weatherapplication.Service;

import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherapplication.dao.WeatherRepository;
import com.weather.weatherapplication.entity.Weather;
import com.weather.weatherapplication.entity.WeatherDataResponse;
import com.weather.weatherapplication.entity.WeatherDataResponse.Current;
import com.weather.weatherapplication.entity.WeatherDataResponse.Location;
import com.weather.weatherapplication.service.WeatherServiceImpl;

@SpringBootTest
public class WeatherServiceImplTest {

	@InjectMocks
	private WeatherServiceImpl weatherServiceImpl;

	@Mock
	RestTemplate restTemplate;

	@Mock
	WeatherRepository weatherRepo;

	@Test
	public void weatherDataTest() throws Exception {
		WeatherDataResponse weatherDataResponse = new WeatherDataResponse();
		Location location = new Location();
		location.setName("London");
		weatherDataResponse.setLocation(location);

		Current current = new Current();
		current.setTemp_c(10);
		weatherDataResponse.setCurrent(current);

		  ResponseEntity<WeatherDataResponse> responseEntity = ResponseEntity.ok(weatherDataResponse);

		  Mockito.when(
		   restTemplate.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class) , Mockito.isNull(), Mockito.any(Class.class))).thenReturn(responseEntity);
		  
		  Weather weather = new Weather();
		  weather.setCity("London");
		Mockito.when(weatherRepo.save(Mockito.any())).thenReturn(weather);
		  Weather actualResponsse = weatherServiceImpl.weatherData("London");
		  Assert.assertEquals("London", actualResponsse.getCity());
		  verify(weatherRepo, times(1)).save(Mockito.any());
	}
	@Test
	public void weatherDataTestException() throws Exception {
		WeatherDataResponse weatherDataResponse = new WeatherDataResponse();
		Location location = new Location();
		location.setName("London");
		weatherDataResponse.setLocation(location);
		Current current = new Current();
		current.setTemp_c(10);
		weatherDataResponse.setCurrent(current);
		  ResponseEntity<WeatherDataResponse> responseEntity = ResponseEntity.ok(weatherDataResponse);
		  Mockito.when(
				  restTemplate.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class) , Mockito.isNull(), Mockito.any(Class.class))).thenThrow(new IllegalArgumentException());

		Assert.assertThrows(Exception.class,()-> weatherServiceImpl.weatherData("London"));


	}
	
	@Test

	public void weatherDataTestFailure() throws Exception{

		WeatherDataResponse weatherDataResponse = new WeatherDataResponse();

		Location location = new Location();

		location.setName("London");

		weatherDataResponse.setLocation(location);

		Current current = new Current();

		current.setTemp_c(10);

		weatherDataResponse.setCurrent(current);

		ResponseEntity<WeatherDataResponse> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	    Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class),

	           Mockito.isNull(), Mockito.any(Class.class)))

	            .thenReturn(responseEntity);

	    Weather result = weatherServiceImpl.weatherData(null);

    Assert.assertNull(result);

	}
}

