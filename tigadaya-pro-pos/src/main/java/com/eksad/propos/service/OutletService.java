package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.OutletModel;

public interface OutletService {
	public List<OutletModel> getList();
	public List<OutletModel> search(String key);
	public OutletModel getById(Integer id);
	public void insert(OutletModel model);
	public void update(OutletModel model);
}
