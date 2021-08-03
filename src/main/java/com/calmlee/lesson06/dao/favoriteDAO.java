package com.calmlee.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.calmlee.lesson06.model.Favorite;

@Repository
public interface favoriteDAO {

	public void insertFavorite(
			@Param("name") String name,
			@Param("url") String url
			);
	
	public List<Favorite> selectFavorite();
	
}
