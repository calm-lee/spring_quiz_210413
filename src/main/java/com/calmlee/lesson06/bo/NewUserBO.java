package com.calmlee.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson06.dao.NewUserDAO;
import com.calmlee.lesson06.model.NewUser;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	public List<NewUser> selectUser() {
		return newUserDAO.getUser();
	}
	
	public void addNewUser(String name, String birth, String introduce, String email) {
		newUserDAO.insertNewUser(name, birth, introduce, email);
	}

}
