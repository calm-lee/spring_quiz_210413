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
	
	// 메인페이지
	@RequestMapping("/pension")
	public String quiz01(Model model) {
		
		// DB에서 select
		List<Booking> booking = pensionBO.getBooking();
		model.addAttribute("bookingList", booking);
		
		return "lesson06/booking";
	}
	
	// 삭제용
	@DeleteMapping("/delete_booking")
	@ResponseBody //ajax 호출이므로
	public Map<String, String> delete(@RequestParam("deleted_id") int id) {
		
		// 쿼리로 id에 해당하는 booking 삭제
		Map<String, String> result = new HashMap<>();
		
		int deletedRow = pensionBO.deleteBookingById(id);
		
		if(deletedRow > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	//예약 페이지
	
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
		
		//DB에 insert
		pensionBO.addBooking(name, headcount, date, day, phoneNumber);
		
		//ajax와 연결
		Map<String, String> result = new HashMap<>();
		result.put("result", "예약이 완료되었습니다.");
		return result;
	}
	
}
