package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.SupplierModel;

public interface SupplierService {
	public List<SupplierModel> getList();
	public List<SupplierModel> search(String key);
	public SupplierModel getById(Integer id);
	public void insert(SupplierModel model);
	public void update(SupplierModel model);
}
