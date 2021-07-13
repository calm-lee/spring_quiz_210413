package com.calmlee.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller
public class Controller01 {

	@RequestMapping("/1")
	@ResponseBody
	public String printString() {
		String text = "<h1>테스트 프로젝트 완성</h1><br>해당 프로젝트를 통해서 문제 풀이를 진행합니다.";
		return text;
	}
	
	
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap(){
		Map<String, Object> map = new HashMap<>();
			map.put("국어", 100);
			map.put("영어", 90);
			map.put("수학", 70);
			
			return map; //JSON으로 return
		}
	}