package com.calmlee.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public List<RealEstate> selectRealEstate(@Param("rentPrice") int rentPrice);
	
	
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") int rentPrice			
			);
	
}
