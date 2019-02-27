package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.PurchaseOrderModel;


public interface PurchaseOrderDao {

	public List<PurchaseOrderModel> getList();
	public List<PurchaseOrderModel> search(String tglAwal, String tglAkhir, String status, String poNo);
	public PurchaseOrderModel getById (Integer id);
	public void editPo(PurchaseOrderModel poModel);
}
