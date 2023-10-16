package com.weather.weatherapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching

public class WeatherapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherapplicationApplication.class, args);
	}


    @Bean
    RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

}
