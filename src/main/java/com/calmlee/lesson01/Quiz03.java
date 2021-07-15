package com.calmlee.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Quiz03 {
	
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03_1() {
		return "lesson01/quiz03";
	}

}
