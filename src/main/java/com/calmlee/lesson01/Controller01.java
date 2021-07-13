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
		String text = "<h1>�׽�Ʈ ������Ʈ �ϼ�</h1><br>�ش� ������Ʈ�� ���ؼ� ���� Ǯ�̸� �����մϴ�.";
		return text;
	}
	
	
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap(){
		Map<String, Object> map = new HashMap<>();
			map.put("����", 100);
			map.put("����", 90);
			map.put("����", 70);
			
			return map; //JSON���� return
		}
	}