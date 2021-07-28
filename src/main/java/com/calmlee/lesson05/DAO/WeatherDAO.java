package com.calmlee.lesson05.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.calmlee.lesson05.Model.Weather;

@Repository
public interface WeatherDAO {
	
	public List<Weather> getWeather();
	
}
