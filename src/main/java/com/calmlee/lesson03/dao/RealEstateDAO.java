package com.calmlee.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public List<RealEstate> selectRealEstate(@Param("rentPrice") int rentPrice);
	
}
