package com.calmlee.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calmlee.lesson06.bo.favoriteBO;
import com.calmlee.lesson06.model.Favorite;


@Controller
@RequestMapping("/lesson06")
public class favoriteController {
	
	@Autowired
	private favoriteBO favoriteBO;
	
	@RequestMapping("/addFavorite")
	public String quiz01() {
		return "lesson06/addFavorite";
	}
	
	// AJAX의 요청이 왔을 때, 
	//서버 쪽에서 @ResponseBody 어노테이션을 사용해야 한다.
	// 리턴되는 값이 반드시 있어야 한다.
	
	@PostMapping("/after_add")
	@ResponseBody
	public Map<String, String> quiz02(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		//DB Insert
		favoriteBO.addFavorite(name, url);
		
		//select
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("result", "success");		
		return resultMap;
	}
	
	
	@RequestMapping("/favorite_list")
	public String favoirteListView(Model model) {
		
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/favoriteTable";
	}
	
	@RequestMapping("/is_duplication")
	@ResponseBody
	public Map<String, Boolean> isDuplication(
			@RequestParam("url") String url
			){
		
		Favorite favorite = favoriteBO.existedByUrl(url);
		
		Map<String, Boolean> result = new HashMap<>();
		
		result.put("isDuplication", false);
		if(favorite != null) {
			result.put("isDuplication", true);
		}
		
		return result;
	}
	
}
