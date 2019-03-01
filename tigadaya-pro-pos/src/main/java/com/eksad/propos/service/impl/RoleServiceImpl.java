package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.RoleDao;
import com.eksad.propos.model.RoleModel;
import com.eksad.propos.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao dao;
	@Override
	public List<RoleModel> getList() {
			return this.dao.getList();
		}
	@Override
	public void insert(RoleModel model) {
		this.dao.insert(model);
		
	}

}
