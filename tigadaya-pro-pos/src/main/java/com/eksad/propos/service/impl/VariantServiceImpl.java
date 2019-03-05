package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eksad.propos.dao.VariantDao;
import com.eksad.propos.model.VariantModel;
import com.eksad.propos.service.VariantService;

@Service
@Transactional
public class VariantServiceImpl implements VariantService {
	
	@Autowired
	private VariantDao dao;
	
	@Override
	public void insert(VariantModel model) {
		this.dao.insert(model);
		
	}

	@Override
	public List<VariantModel> getList() {
		return this.dao.getList();
	}

	@Override
	public VariantModel getByItemId(Integer id) {
		return this.dao.getByItemId(id);
	}

	@Override
<<<<<<< HEAD
	public String getNewSku() {
		return this.dao.getNewSku();
	}
	}
=======
	public List<VariantModel> getByVarId(Integer id) {
		return this.dao.getByVarId(id);
	}

}
>>>>>>> 2a108cb5d90c2aee81e4c02f152012596f4efe85

	
