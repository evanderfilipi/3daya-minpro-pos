package com.eksad.propos.dao;
import java.util.List;

import com.eksad.propos.model.InvenModel;
import com.eksad.propos.model.ItemModel;


public interface ItemDao {
	
	public List<ItemModel> getList();
	public List<InvenModel> getInvenList();
	public void insert(ItemModel model);
	public List<ItemModel> search(String key);
	public ItemModel getById(Integer id);
	public void update(ItemModel model);
}
