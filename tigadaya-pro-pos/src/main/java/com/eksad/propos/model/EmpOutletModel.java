package com.eksad.propos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pos_employee_outlet")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=EmpOutletModel.class)
public class EmpOutletModel {
	@Id
	@Column(name="ID", columnDefinition="serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_employee_outlet_seq")
	@TableGenerator(name = "pos_employee_outlet_seq", table = "tbl_squence", 
	pkColumnName = "seq_id", valueColumnName = "seq_value", 
	initialValue = 0, allocationSize=1)
	private Integer id;

	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="outlet_id")
	private Integer outletId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getOutletId() {
		return outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}
}