package com.calmlee.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calmlee.lesson03.bo.RealEstateBO;
import com.calmlee.lesson03.model.RealEstate;

@RestController
public class RealEstateRestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/lesson03/quiz01/1")
	public List<RealEstate> quiz01(
			@RequestParam(value="rentPrice") int rentPrice			
			) {
		System.out.println("### rentPrice : " + rentPrice);
		return realEstateBO.getRealEstate(rentPrice);
	}
}
