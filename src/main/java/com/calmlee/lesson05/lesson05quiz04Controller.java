package com.calmlee.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calmlee.lesson05.BO.WeatherBO;
import com.calmlee.lesson05.Model.Weather;

@Controller
public class lesson05quiz04Controller {

	@Autowired
	private WeatherBO weatherBO;
	
	@RequestMapping("/lesson05/quiz04")
	
	public String weatherHistoryController(Model model) {
		
		List<Weather> weather = weatherBO.selectWeather();
		
		model.addAttribute("weather", weather);
		
		return "lesson05/quiz04";
	}	
}
