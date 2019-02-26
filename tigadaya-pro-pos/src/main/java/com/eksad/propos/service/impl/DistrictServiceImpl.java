package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.DistrictDao;
import com.eksad.propos.model.DistrictModel;
import com.eksad.propos.service.DistrictService;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictDao disDao;
	
	@Override
	public List<DistrictModel> getList() {
		return this.disDao.getList();
	}

	@Override
	public List<DistrictModel> getById(Integer id) {
		return this.disDao.getById(id);
	}

}
