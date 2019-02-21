package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.eksad.propos.dao.ItemDao;
import com.eksad.propos.model.ItemModel;
import com.eksad.propos.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao dao;
	
	@Override
	public List<ItemModel> getList() {
		return this.dao.getList();
	}
	
	@Override
	public void insert(ItemModel model) {
		this.dao.insert(model);
		
	}
	

}
