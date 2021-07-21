package com.calmlee.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson04.bo.SellerBO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;

	@RequestMapping(path = "/1", method = RequestMethod.GET)
	
	public String addSellerView() {
		return "lesson04/AddSeller";
	}
	
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		//DB insert
		sellerBO.insertNewSeller(nickname, profileImageUrl, temperature);
		
		//°á°ú jsp
		return "lesson04/afterAddSeller";
	}
	
	
}
