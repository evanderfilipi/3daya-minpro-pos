package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.PrDetailDao;
import com.eksad.propos.model.PrDetailModel;
import com.eksad.propos.service.PrDetailService;

@Service
@Transactional
public class PrDetailServiceImpl implements PrDetailService {
	@Autowired
	private PrDetailDao prdDao;
	
	@Override
	public List<PrDetailModel> getList() {
		return this.prdDao.getList();
	}

	@Override
	public List<PrDetailModel> getByPrId(Integer id) {
		return this.prdDao.getByPrId(id);
	}

	@Override
	public List<PrDetailModel> getByVarId(Integer varId) {
		return this.prdDao.getByVarId(varId);
	}

}
