package com.calmlee.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson04.dao.SellerDAO;
import com.calmlee.lesson04.model.Seller;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public void insertNewSeller(String nickname, String profileImageUrl, double temperature) {
		sellerDAO.insertNewSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getLastSeller() {
		return sellerDAO.getLastSeller();
	}
	
	public Seller getSellerById(int id) {
		return sellerDAO.getSellerById(id);
	}
	
}
