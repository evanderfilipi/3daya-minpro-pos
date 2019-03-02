package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.EmpOutletDao;
import com.eksad.propos.model.EmpOutletModel;
import com.eksad.propos.service.EmpOutletService;


@Service
@Transactional
public class EmpOutletServiceImpl implements EmpOutletService {
	@Autowired
	private EmpOutletDao dao;

	@Override
	public List<EmpOutletModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public EmpOutletModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(EmpOutletModel model) {
		this.dao.insert(model);
	}

	
	
}