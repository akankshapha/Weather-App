package com.weather.weatherapplication.advice;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.weather.weatherapplication.Exception.WeatherException;
@SpringBootTest
public class AdviceTest {
	@Mock

    private WeatherException weatherException;



    @InjectMocks

    private WeathercontrollerAdvice advice;



    private MockMvc mockMvc;



    @BeforeEach

    public void setUp() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(advice).build();

    }



    @Test

    public void testHandleWeatherException() throws Exception {

        String errorMessage = "Weather exception message";

        when(weatherException.getMessage()).thenReturn(errorMessage);

        ResponseEntity<String> response = advice.handWeatherException(weatherException);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        Assert.assertEquals(errorMessage, response.getBody());

    }
}
