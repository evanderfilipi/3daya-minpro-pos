package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.EmployeeModel;

public interface EmployeeDao {
	public List<EmployeeModel> getList();
	public void insert(EmployeeModel model);
	public void update(EmployeeModel model);
	public EmployeeModel getById(Integer id);
	public void delete(EmployeeModel model);
}
