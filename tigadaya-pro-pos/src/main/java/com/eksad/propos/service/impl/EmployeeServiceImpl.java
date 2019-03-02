package com.eksad.propos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eksad.propos.dao.EmployeeDao;
import com.eksad.propos.dao.UserDao;
import com.eksad.propos.model.EmployeeModel;
import com.eksad.propos.model.StaffForm;
import com.eksad.propos.model.UserModel;
import com.eksad.propos.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private UserDao daoUser;
//	@Autowired
//	private OutletDao daoOutlet

	@Override
	public List<EmployeeModel> getList() {
		return this.dao.getList();
	}

	@Override
	public void update(EmployeeModel model) {
		this.dao.update(model);

	}

	@Override
	public EmployeeModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void delete(EmployeeModel model) {
		this.dao.delete(model);

	}

	@Override
	public void insert(StaffForm model) {
		// input data ke tabel employee
		EmployeeModel emp = model.getEmployee();
		this.dao.insert(emp);
		
		// input data ke tabel User
		UserModel us = model.getUser();
		us.setEmployeeId(emp.getId());
		this.daoUser.insert(us);
		
		//if (model.getUser() != null) {
		//	for (UserModel user : model.getUser()) {
		//		user.setEmployeeId(emp.getId());
		//		this.daoUser.insert(user);
		//	}
		//}
	}
	/*	 input data ke tabel Outlet
		if (model.getUser() != null) {
			for (UserOutlet outlet : model.getOutlet()) {
				outlet.setEmployeeId(emp.getId());
				this.daoOutlet.insert(outlet);
			}
		}
	*/
}
