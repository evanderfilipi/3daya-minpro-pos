package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.SupplierModel;

public interface SupplierDao {
	public List<SupplierModel> getList();
	public List<SupplierModel> search(String key);
	public SupplierModel getById(Integer id);
	public void insert(SupplierModel model);
	public void update(SupplierModel model);
}
