package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.TsDao;
import com.eksad.propos.model.TsModel;
import com.eksad.propos.service.TsService;

@Service
@Transactional
public class TsServiceImpl implements TsService {

	@Autowired
	private TsDao dao;
	
	@Override
	public List<TsModel> getList() {
		return this.dao.getList();
	}

	@Override
	public List<TsModel> search(String key) {
		return this.dao.search(key);
	}

	@Override
	public List<TsModel> getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(TsModel model) {
		this.dao.insert(model);
	}

}
