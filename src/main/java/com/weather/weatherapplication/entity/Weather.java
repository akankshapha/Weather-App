package com.weather.weatherapplication.entity;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather")
public class Weather implements Serializable{
	
	 	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private String city;
	    private double temperature;
	    private double humidity;
	    
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public double getTemperature() {
			return temperature;
		}
		public void setTemperature(double temperature) {
			this.temperature = temperature;
		}
		public double getHumidity() {
			return humidity;
		}
		public void setHumidity(double humidity) {
			this.humidity = humidity;
		}
		
		
		public Weather() {
			super();
			
		}
		
		public Weather(Integer id, String city, double temperature, double humidity) {
			super();
			this.id = id;
			this.city = city;
			this.temperature = temperature;
			this.humidity = humidity;
		}

	    
		
		
}
