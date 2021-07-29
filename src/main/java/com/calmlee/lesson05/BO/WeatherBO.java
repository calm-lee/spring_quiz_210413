package com.calmlee.lesson05.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson05.DAO.WeatherDAO;
import com.calmlee.lesson05.Model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<Weather> selectWeather() {
		return weatherDAO.getWeather();
	}
	
	public void addWeather(
			String date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		weatherDAO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
