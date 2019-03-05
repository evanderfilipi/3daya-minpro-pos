package com.eksad.propos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eksad.propos.dao.AdjustmentInputDao;
import com.eksad.propos.model.AdjustmentInputModel;
import com.eksad.propos.service.AdjustmentInputService;

@Service
@Transactional
public class AdjustmentInputServiceImpl implements AdjustmentInputService{
	@Autowired
	private AdjustmentInputDao dao;
	
	@Override
	public List<AdjustmentInputModel> getList() {
		return this.dao.getList();
	}

	@Override
	public AdjustmentInputModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public AdjustmentInputModel getBy(Integer adId) {
		return this.dao.getByAdid(adId);
	}

	@Override
	public void insert(AdjustmentInputModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(AdjustmentInputModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(AdjustmentInputModel model) {
		this.dao.delete(model);
	}

}