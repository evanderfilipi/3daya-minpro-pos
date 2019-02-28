package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.PoHistoryDao;
import com.eksad.propos.model.PoHistoryModel;
import com.eksad.propos.service.PoHistoryService;

@Service
@Transactional
public class PoHistoryServiceImpl implements PoHistoryService {
	
	@Autowired
	private PoHistoryDao poHdao;

	@Override
	public List<PoHistoryModel> getByPoId(Integer poId) {
		return this.poHdao.getByPoId(poId);
	}

	@Override
	public void insert(PoHistoryModel model) {
		this.poHdao.insert(model);
	}

}
