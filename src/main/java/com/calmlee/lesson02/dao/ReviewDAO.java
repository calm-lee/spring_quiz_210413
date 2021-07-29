package com.calmlee.lesson02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson02.model.Review;

@Repository
public interface ReviewDAO {
	
	public List<Review> getReview(@Param("storeId") int storeId);
		
}
