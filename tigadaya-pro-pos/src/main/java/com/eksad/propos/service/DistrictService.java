package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.DistrictModel;

public interface DistrictService {
	public List<DistrictModel> getList();
	public List<DistrictModel> getById(Integer id);
}
