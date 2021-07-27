package com.calmlee.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class lesson05quiz02Controller {
	
	@RequestMapping("/lesson05/quiz02_3")
	public String quiz02_3(Model model) {
		
		List<Integer> candidates = new ArrayList<>();
		candidates.add(263001);
		candidates.add(173942); 
		candidates.add(563057); 
		
		model.addAttribute("candidates", candidates);
		model.addAttribute("totalCount", 100000);
		
		return "lesson05/quiz02_3";
	}

	@RequestMapping("/lesson05/quiz02_4")
	
	public String quiz02_4(Model model) {
		List<Map<String, Object>> cardBills = new ArrayList<>();

		Map<String, Object> cardBill = new HashMap<>();
		cardBill.put("store", "GS48");
		cardBill.put("pay", 7800);
		cardBill.put("date", "2025-09-14");
		cardBill.put("installment", "�Ͻú�");
		cardBills.add(cardBill);

		cardBill = new HashMap<>();
		cardBill.put("store", "���¹�ȭ��");
		cardBill.put("pay", 2750000);
		cardBill.put("date", "2025-09-18");
		cardBill.put("installment", "3����");
		cardBills.add(cardBill);

		cardBill = new HashMap<>();
		cardBill.put("store", "����ġŲ");
		cardBill.put("pay", 180000);
		cardBill.put("date", "2025-09-20");
		cardBill.put("installment", "�Ͻú�");
		cardBills.add(cardBill);
		
		model.addAttribute("cardBill", cardBills);
	
		return "lesson05/quiz02_4";
	}
}
