package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.RegionDao;
import com.eksad.propos.model.RegionModel;
import com.eksad.propos.service.RegionService;

@Service
@Transactional
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionDao dao;
	
	@Override
	public List<RegionModel> getList() {
		return this.dao.getList();
	}

	@Override
	public List<RegionModel> getById(Integer id) {
		return this.dao.getById(id);
	}
}
