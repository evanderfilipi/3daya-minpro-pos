package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.PoDetailDao;
import com.eksad.propos.model.PoDetailModel;
import com.eksad.propos.service.PoDetailService;

@Service
@Transactional
public class PoDetailServiceImpl implements PoDetailService {
	
	@Autowired
	private PoDetailDao podDao;

	@Override
	public List<PoDetailModel> getList() {
		return this.podDao.getList();
	}

	@Override
	public List<PoDetailModel> getByPoId(Integer id) {
		return this.podDao.getByPoId(id);
	}

	@Override
	public List<PoDetailModel> getByVarId(Integer varId) {
		return this.podDao.getByVarId(varId);
	}

}
