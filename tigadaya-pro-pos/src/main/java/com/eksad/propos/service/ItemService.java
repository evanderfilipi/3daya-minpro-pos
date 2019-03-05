package com.eksad.propos.service;

import java.util.List;


import com.eksad.propos.model.ItemModel;
import com.eksad.propos.model.InvenModel;
import com.eksad.propos.model.ItemForm;

public interface ItemService {
	
	public List<ItemModel> getList();
	public List<InvenModel>getListInven();
	public List<ItemModel> search(String key);
	public ItemModel getById(Integer id);
	public void insert(ItemForm model);
	public void update(ItemModel model);
}
