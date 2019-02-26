package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.RegionModel;

public interface RegionService {
	public List<RegionModel> getList();
	public List<RegionModel> getById(Integer id);
}
