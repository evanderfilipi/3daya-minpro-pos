package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.RegionModel;

public interface RegionDao {
	public List<RegionModel> getList();
	public List<RegionModel> getById(Integer id);
}
