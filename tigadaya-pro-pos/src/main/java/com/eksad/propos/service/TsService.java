package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.TsModel;

public interface TsService {
	public List<TsModel> getList();
	public List<TsModel> search(String key);
	public List<TsModel> getById(Integer id);
	public void insert(TsModel model);
}
