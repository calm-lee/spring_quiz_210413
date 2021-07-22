package com.calmlee.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson04.bo.SellerBO;
import com.calmlee.lesson04.model.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;

	//요청 URL: http://localhost.lesson04/quiz01/1
	@RequestMapping(path = "/1", method = RequestMethod.GET)
	
	public String addSellerView() {
		return "lesson04/AddSeller";
	}
	
	//요청 URL: http://localhost.lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		//DB insert
		sellerBO.insertNewSeller(nickname, profileImageUrl, temperature);
		
		//결과 jsp
		return "lesson04/afterAddSeller";
	}
	
	//요청 URL: http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		Seller seller = null;
		if(id == null) {		
			seller = sellerBO.getLastSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("seller", seller);
		return "lesson04/sellerInfo";
	}
}