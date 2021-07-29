package com.calmlee.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson05.BO.WeatherBO;
import com.calmlee.lesson05.Model.Weather;

@RequestMapping("/lesson05")
@Controller
public class lesson05quiz04Controller {

	@Autowired
	private WeatherBO weatherBO;
	
	@RequestMapping("/weather_history_view")
	public String weatherHistoryController(Model model) {
		
		List<Weather> weather = weatherBO.selectWeather();
		
		model.addAttribute("weather", weather);
		
		return "lesson05/weather_history";
	}	
	
	
	@RequestMapping("/add_weather_view")
	public String addWeather()
	{	
		return "lesson05/add_weather";
	}
	
	@PostMapping("/add_weather")
	public String afterAddWeather(
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed)
	{
		//DB insert
		weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		//redirect: ���ο� ������Ʈ�� �ϴ� �Ͱ� �����Ƿ� RequestMapping�� �ִ� path�� ���ش�. 
		return "redirect:/lesson05/weather_history_view";
		
	}
}