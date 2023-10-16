package com.weather.weatherapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDataResponse {
	
	private Location location;
	private Current current;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	
	
	public static class Location {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}	
	}
	
	
	
	public static class Current{
		private double temp_c;
		private double humidity;
		public double getTemp_c() {
			return temp_c;
		}
		public void setTemp_c(double temp_c) {
			this.temp_c = temp_c;
		}
		public double getHumidity() {
			return humidity;
		}
		public void setHumidity(double humidity) {
			this.humidity = humidity;
		}
		
		
	}

}
