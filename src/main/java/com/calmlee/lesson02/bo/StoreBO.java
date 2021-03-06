package com.calmlee.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmlee.lesson02.dao.StoreDAO;
import com.calmlee.lesson02.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreDAO storeDAO; // 의존성 주입
	
	public List<Store> getStoreList(){
		return storeDAO.selectStoreList();
	}

}
