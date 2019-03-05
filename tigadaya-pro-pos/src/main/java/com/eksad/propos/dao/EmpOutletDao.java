package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.EmpOutletModel;


public interface EmpOutletDao {
	public List<EmpOutletModel> getList();
	public EmpOutletModel getById(Integer id);
	public void insert(EmpOutletModel model);

}