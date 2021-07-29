package com.calmlee.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calmlee.lesson06.bo.NewUserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class lesson06Controller {

	@Autowired
	private NewUserBO newUserBO;
		
	
	/**
	 * 사용자를 추가할 수 있는 화면
	 * @return
	 */
	
	@RequestMapping("/addUser")
	public String ex01() {
		return "lesson06/addNewUser";
	}
	
	@PostMapping("/add_new_user")
	@ResponseBody
	public String addNewUser(
			@RequestParam("name") String name
			,@RequestParam("birth") String birth
			,@RequestParam(value="email", required=false) String email
			,@RequestParam(value="introduce", required=false) String introduce) {
		
		newUserBO.addNewUser(name, birth, introduce, email);
		
		return "success";
	}
}
