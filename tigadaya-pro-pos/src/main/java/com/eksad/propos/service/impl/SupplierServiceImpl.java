package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.SupplierDao;
import com.eksad.propos.model.SupplierModel;
import com.eksad.propos.service.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supDao;
	
	@Override
	public List<SupplierModel> getList() {
		return this.supDao.getList();
	}

	@Override
	public List<SupplierModel> search(String key) {
		return this.supDao.search(key);
	}

	@Override
	public void insert(SupplierModel model) {
		this.supDao.insert(model);
	}

	@Override
	public void update(SupplierModel model) {
		this.supDao.update(model);
	}

	@Override
	public SupplierModel getById(Integer id) {
		return this.supDao.getById(id);
	}

}
