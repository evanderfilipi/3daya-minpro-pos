package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.OutletDao;
import com.eksad.propos.model.OutletModel;
import com.eksad.propos.service.OutletService;

@Service
@Transactional
public class OutletServiceImpl implements OutletService {
	
	@Autowired
	private OutletDao dao;

	@Override
	public List<OutletModel> getList() {
		return this.dao.getList();
	}

}
