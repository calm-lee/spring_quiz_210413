package com.calmlee.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson02.bo.StoreBO;
import com.calmlee.lesson02.model.Store;

@Controller
public class Quiz01RestController {

	@Autowired
	private StoreBO storeBO;

	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		List<Store> storeList = storeBO.getStoreList();
		return storeList;

	}

	@RequestMapping("/lesson05/storeList")
	public String storeList(Model model) {
		List<Store> storeList = storeBO.getStoreList();

		model.addAttribute("storeList", storeList);
		return "lesson05/storeList";
	}
	
	@PostMapping("/lesson05/reviews")
	public String review(@RequestParam("storeId") int id) {
		return "lesson05/reviews";
	}
	
}