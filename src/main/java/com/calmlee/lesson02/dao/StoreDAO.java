package com.calmlee.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.calmlee.lesson02.model.Store;

@Repository
public interface StoreDAO {
	public List<Store> selectStoreList();
}
