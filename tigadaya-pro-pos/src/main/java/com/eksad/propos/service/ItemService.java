package com.eksad.propos.service;

import java.util.List;


import com.eksad.propos.model.ItemModel;

public interface ItemService {
	
	public List<ItemModel> getList();
	public void insert(ItemModel model);
}
