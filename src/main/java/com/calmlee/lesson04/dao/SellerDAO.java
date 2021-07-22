package com.calmlee.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson04.model.Seller;

@Repository
public interface SellerDAO {

	public void insertNewSeller(
			@Param("nickname") String nickname,
			@Param("profileImageUrl") String profileImageUrl,
			@Param("temperature") double temperature
	);
	
	public Seller getLastSeller();
	
	public Seller getSellerById(int id);
	
}
