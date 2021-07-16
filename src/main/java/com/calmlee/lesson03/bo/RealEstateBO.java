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
	
	public List<RealEstate> getRealEstate(int rentPrice) {
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstate(rentPrice);
		return realEstateList;
	}

}
