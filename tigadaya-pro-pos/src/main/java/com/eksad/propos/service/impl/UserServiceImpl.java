package com.eksad.propos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eksad.propos.dao.EmployeeDao;
import com.eksad.propos.dao.UserDao;
import com.eksad.propos.model.UserModel;
import com.eksad.propos.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public List<UserModel> getList() {
		return this.dao.getList();
	}

	@Override
	public void insert(UserModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(UserModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(UserModel model) {
		this.dao.delete(model);
	}

	@Override
	public UserModel getById(Integer id) {
		return this.dao.getById(id);
	}

}
