package com.weather.weatherapplication.Entity;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.weather.weatherapplication.entity.Weather;

@SpringBootTest
public class WeatherEntityTest {

	@Test
	  public void testWeatherDataGettersAndSetters() {
	       Weather weatherData = new Weather();
	       weatherData.setId(1);
	       weatherData.setCity("New York");
	       weatherData.setHumidity(10.0);
	       
	  
	        assertEquals(1, weatherData.getId());
            assertEquals("New York", weatherData.getCity());
            assertEquals(10.0, weatherData.getHumidity());
}

	
	@Test
  public void testWeatherDataConstructor() {



    Integer id = 1;
    String cityName = "New York";
    Double temperature = 25.0;
    Double humidity = 50.0;
    Weather weatherData = new Weather(id, cityName, temperature, humidity);



    assertEquals(id, weatherData.getId());
    assertEquals(cityName, weatherData.getCity());
    assertEquals(temperature, weatherData.getTemperature());
    assertEquals(humidity, weatherData.getHumidity());
  }
}
