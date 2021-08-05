package com.calmlee.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.lesson06.bo.pensionBO;
import com.calmlee.lesson06.model.Booking;

@RequestMapping("/lesson06")
@Controller
public class pensionController {
	
	@Autowired
	private pensionBO pensionBO;
	
	@RequestMapping("/pension")
	public String quiz01(Model model) {
		
		// DB에서 select
		List<Booking> booking = pensionBO.getBooking();
		model.addAttribute("bookingList", booking);
		
		return "lesson06/booking";
	}
	
	// 삭제용
	@RequestMapping("/delete_booking")
	public String delete(@RequestParam("deleted_id") int id) {
		
		int deletedRow = pensionBO.deleteBookingById(id);
	
		return deletedRow == 1 ? "success" : "fail"; 
	}
	
}
