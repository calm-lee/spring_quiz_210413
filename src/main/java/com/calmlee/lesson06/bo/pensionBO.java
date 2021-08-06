package com.calmlee.lesson06.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson06.dao.pensionDAO;
import com.calmlee.lesson06.model.Booking;

@Service
public class pensionBO {

	@Autowired
	private pensionDAO pensionDAO;
	
	public List<Booking> getBooking(){
		return pensionDAO.selectBooking();
	}
	
	public int deleteBookingById(int id) {
		return pensionDAO.deleteBookingById(id);
	}

	public void addBooking(String name, int headcount, String date, int day, String phoneNumber) {
		pensionDAO.insertBooking(name, headcount, date, day, phoneNumber);
	}
	
}
