package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.PurchaseRequestDao;
import com.eksad.propos.model.PurchaseRequestModel;
import com.eksad.propos.service.PurchaseRequestService;


@Service
@Transactional
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
	@Autowired
	private PurchaseRequestDao dao;

	@Override
	public List<PurchaseRequestModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public PurchaseRequestModel getById(Integer id) {
		return this.dao.getById(id);
	}
	@Override
	public void insert(PurchaseRequestModel model) {
		this.dao.insert(model);
	}


	@Override
	public String getNewCode() {
		return this.dao.getNewCode();
	}

}
