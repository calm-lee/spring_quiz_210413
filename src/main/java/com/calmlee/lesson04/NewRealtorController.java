package com.calmlee.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calmlee.lesson04.bo.RealtorBO;
import com.calmlee.lesson04.model.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class NewRealtorController {
	
	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/1")
	public String quiz02_1() {
		return "lesson04/addRealtor";
	}
	
	//http://localhost/lesson04/quiz02/add_realtor
	
	@PostMapping("/add_realtor")
	public String quiz02_2(
			@ModelAttribute Realtor realtor,
			Model model
			) {
		
		// 1. 파라미터를 받는다.
		
		// 2. DB insert한다.
		realtorBO.addRealtor(realtor);
		
		// 3. DB select를 해와서 view 페이지에 넣는다 -> response
		Realtor newRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("realtor", newRealtor);
		
		return "lesson04/afterAddRealtor";

	}
}
