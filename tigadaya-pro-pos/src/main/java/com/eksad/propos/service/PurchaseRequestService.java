package com.eksad.propos.service;

import java.util.List;


import com.eksad.propos.model.PurchaseRequestModel;

public interface PurchaseRequestService {
	public List<PurchaseRequestModel> getList();
	public PurchaseRequestModel getById(Integer id);
	public void insert(PurchaseRequestModel model);
	public String getNewCode();
}
