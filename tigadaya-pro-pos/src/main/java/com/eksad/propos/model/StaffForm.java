package com.eksad.propos.model;

import java.util.List;

public class StaffForm {
	private EmployeeModel employee;
	private UserModel user;
	private List<EmpOutletModel> outlet;
	
	public List<EmpOutletModel> getOutlet() {
		return outlet;
	}
	public void setOutlet(List<EmpOutletModel> outlet) {
		this.outlet = outlet;
	}
	public EmployeeModel getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
}
