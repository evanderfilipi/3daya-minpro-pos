package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.PrHistoryDao;
import com.eksad.propos.model.PrHistoryModel;
import com.eksad.propos.service.PrHistoryService;

@Service
@Transactional
public class PrHistoryServiceImpl implements PrHistoryService {
	@Autowired
	private PrHistoryDao prHdao;
	
	@Override
	public List<PrHistoryModel> getByPrId(Integer prId) {
		return this.prHdao.getByPrId(prId);
	}

	@Override
	public void insert(PrHistoryModel model) {
		this.prHdao.insert(model);
	}
}
