package com.calmlee.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson03.dao.RealEstateDAO;
import com.calmlee.lesson03.model.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateDAO realEstateDAO;

	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstate(rentPrice);
		return realEstateList;
	}

	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		return realEstateDAO.selectRealEstateListByAreaAndPrice(area, price);
	}
	
	public int insertRealEstate(RealEstate realEstate) {
		return realEstateDAO.insertRealEstate(realEstate);
	}
	
	public int insertRealEstateAsField(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateDAO.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
}