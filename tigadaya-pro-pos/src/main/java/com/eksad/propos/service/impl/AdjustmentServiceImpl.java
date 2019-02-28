package com.eksad.propos.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.AdjustmentDao;
import com.eksad.propos.model.AdjustmentModel;
import com.eksad.propos.service.AdjustmentService;

@Service
@Transactional
public class AdjustmentServiceImpl implements AdjustmentService {
	@Autowired
	private AdjustmentDao dao;

	@Override
	public List<AdjustmentModel> getList() {
		return this.dao.getList();
	}

	@Override
	public List<AdjustmentModel> search(String key) {
		return this.dao.search(key);
	}

	@Override
	public AdjustmentModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(AdjustmentModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(AdjustmentModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(AdjustmentModel model) {
		this.dao.delete(model);		
	}
	
}