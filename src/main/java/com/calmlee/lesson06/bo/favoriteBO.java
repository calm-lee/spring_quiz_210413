package com.calmlee.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson06.dao.favoriteDAO;
import com.calmlee.lesson06.model.Favorite;

@Service
public class favoriteBO {

	@Autowired
	private favoriteDAO favoriteDAO;

	public void addFavorite(String name, String url) {
		favoriteDAO.insertFavorite(name, url);
	}

	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavorite();
	}
	
}
