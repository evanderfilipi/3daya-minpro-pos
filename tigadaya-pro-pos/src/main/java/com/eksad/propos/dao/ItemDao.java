package com.eksad.propos.dao;

import java.util.List;


import com.eksad.propos.model.ItemModel;

public interface ItemDao {
	
	public List<ItemModel> getList();
	public void insert(ItemModel model);
	
}
