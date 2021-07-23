package com.calmlee.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.calmlee.lesson04.model.Realtor;

@Repository
public interface RealtorDAO {
	
	public void insertRealtor(Realtor realtor);
	
	public Realtor selectRealtorById(int id);
	
}
