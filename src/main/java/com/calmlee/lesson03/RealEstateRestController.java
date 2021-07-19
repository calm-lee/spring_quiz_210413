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
	
//	����(area) - �Ź��� ���̰� ���� ���� ���� �̻��� ��
//	����(price) - �Ź��� �Ÿű��� ���޹��� �Ÿű� ���� ������ ��
	
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
		realEstate.setAddress("Ǫ������ ���� 303�� 1104ȣ");
		realEstate.setArea(89);
		realEstate.setType("�Ÿ�");
		realEstate.setPrice(100000);
		
		int row = realEstateBO.insertRealEstate(realEstate);
		return "�Է� ����: " + row;
	}
	
	//realtorId�� �ּ� parameter�� ����
	@RequestMapping("/lesson03/quiz02/2")
	public String quiz02_2(@RequestParam("realtorId") int realtorId) {
		int row = realEstateBO.insertRealEstateAsField(
				realtorId,
				"�඼������ ���ǽ��� 814ȣ",
				45,
				"����",
				100000,
				120
				);
		return "�Է� ����: " + row;
	}
	
}
