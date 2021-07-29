package com.calmlee.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson06.model.NewUser;

@Repository
public interface NewUserDAO {

	public List<NewUser> getUser();
	
	public void insertNewUser(@Param("name") String name, @Param("birth") String birth,
			@Param("introduce") String introduce, @Param("email") String email);

}
