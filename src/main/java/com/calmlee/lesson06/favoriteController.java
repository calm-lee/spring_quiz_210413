package com.calmlee.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson06.bo.favoriteBO;

@RequestMapping("/lesson06")
@Controller
public class favoriteController {
	
	@Autowired
	private favoriteBO favoriteBO;
	
	@RequestMapping("/addFavorite")
	public String quiz01() {
		return "lesson06/addFavorite";
	}
	
	@PostMapping("/after_add")
	public String quiz02(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="url", required=false) String url
			) {
		
		favoriteBO.addFavorite(name, url);
		favoriteBO.getFavorite();
		return "lesson06/favoriteTable";
	}
	
}
