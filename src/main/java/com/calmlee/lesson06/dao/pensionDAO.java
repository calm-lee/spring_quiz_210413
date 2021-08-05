package com.calmlee.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson06.model.Booking;

@Repository
public interface pensionDAO {

	public List<Booking> selectBooking();
	
	public int deleteBookingById(@Param("id") int id);
}
