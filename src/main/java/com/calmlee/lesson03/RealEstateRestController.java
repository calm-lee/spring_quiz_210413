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
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
//	넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
//	가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
	
	@RequestMapping("/lesson03/quiz01/2")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price){
		return realEstateBO.getRealEstateListByAreaAndPrice(area, price);
	}
	
	@RequestMapping("/lesson03/quiz02/1")
	public String quiz02_1(){
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int row = realEstateBO.insertRealEstate(realEstate);
		return "입력 성공: " + row;
	}
	
	//realtorId는 주소 parameter로 받음
	@RequestMapping("/lesson03/quiz02/2")
	public String quiz02_2(@RequestParam("realtorId") int realtorId) {
		int row = realEstateBO.insertRealEstateAsField(
				realtorId,
				"썅떼빌리버 오피스텔 814호",
				45,
				"월세",
				100000,
				120
				);
		return "입력 성공: " + row;
	}
	
}
