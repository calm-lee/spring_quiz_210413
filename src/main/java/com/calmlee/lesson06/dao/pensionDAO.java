package com.calmlee.lesson06.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson06.model.Booking;

@Repository
public interface pensionDAO {

	public List<Booking> selectBooking();

	public int deleteBookingById(@Param("id") int id);

	public void insertBooking(@Param("name") String name, @Param("headcount")int headcount, @Param("date") String date, @Param("day") int day,
			@Param("phoneNumber") String phoneNumber);

}
