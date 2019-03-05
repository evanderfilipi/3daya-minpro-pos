package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eksad.propos.dao.InvenDao;
import com.eksad.propos.model.InvenModel;
import com.eksad.propos.service.InvenService;

@Service
@Transactional
public class InvenServiceImpl implements InvenService {
	
	@Autowired
	private InvenDao dao;
	
	@Override
	public void insert(InvenModel model) {
		this.dao.insert(model);
		
	}

	@Override
	public List<InvenModel> getList() {
		return this.dao.getList();
	}
	@Override
	public InvenModel getByInvenId(Integer id) {
		return this.dao.getByInvenId(id);
	}
}

	
