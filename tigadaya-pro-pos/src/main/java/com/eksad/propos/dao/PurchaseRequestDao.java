package com.eksad.propos.dao;

import java.util.List;


import com.eksad.propos.model.PurchaseRequestModel;


public interface PurchaseRequestDao {
	public List<PurchaseRequestModel> getList();
	public PurchaseRequestModel getById(Integer id);
	public void insert(PurchaseRequestModel model);
	//method utk auto increment
	public String getNewCode(); 
}
