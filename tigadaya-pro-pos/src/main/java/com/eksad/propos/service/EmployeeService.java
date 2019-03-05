package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.EmployeeModel;
import com.eksad.propos.model.StaffForm;

public interface EmployeeService {
	public void insert(StaffForm model);
	public List<EmployeeModel> getList();
	public void update(EmployeeModel model);
	public EmployeeModel getById(Integer id);
	public void delete(EmployeeModel model);
}
