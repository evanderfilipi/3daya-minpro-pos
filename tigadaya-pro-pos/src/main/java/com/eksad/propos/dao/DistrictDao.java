package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.DistrictModel;

public interface DistrictDao {
	public List<DistrictModel> getList();
	public List<DistrictModel> getById(Integer id);
}
