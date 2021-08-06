package com.calmlee.lesson06;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calmlee.lesson06.bo.pensionBO;
import com.calmlee.lesson06.model.Booking;

@RequestMapping("/lesson06")
@Controller
public class pensionController {
	
	@Autowired
	private pensionBO pensionBO;
	
	// ����������
	@RequestMapping("/pension")
	public String quiz01(Model model) {
		
		// DB���� select
		List<Booking> booking = pensionBO.getBooking();
		model.addAttribute("bookingList", booking);
		
		return "lesson06/booking";
	}
	
	// ������
	@DeleteMapping("/delete_booking")
	@ResponseBody //ajax ȣ���̹Ƿ�
	public Map<String, String> delete(@RequestParam("deleted_id") int id) {
		
		// ������ id�� �ش��ϴ� booking ����
		Map<String, String> result = new HashMap<>();
		
		int deletedRow = pensionBO.deleteBookingById(id);
		
		if(deletedRow > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	//���� ������
	
	@RequestMapping("/reservation")
	public String reservationView() {
		return "lesson06/addBooking";
	}
	
	@RequestMapping("/add_reservation")
	@ResponseBody
	public Map<String, String> addReservation(
			@RequestParam("name") String name
			, @RequestParam("headCount") int headcount
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("phoneNumber") String phoneNumber
			){		
		
		//DB�� insert
		pensionBO.addBooking(name, headcount, date, day, phoneNumber);
		
		//ajax�� ����
		Map<String, String> result = new HashMap<>();
		result.put("result", "������ �Ϸ�Ǿ����ϴ�.");
		return result;
	}
	
}
