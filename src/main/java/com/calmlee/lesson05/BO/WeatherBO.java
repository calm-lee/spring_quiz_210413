package com.calmlee.lesson05.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson05.DAO.WeatherDAO;
import com.calmlee.lesson05.Model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<Weather> selectWeather() {
		return weatherDAO.getWeather();
	}
}
