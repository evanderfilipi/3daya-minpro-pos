package com.eksad.propos.service;

import java.util.List;


import com.eksad.propos.model.EmpOutletModel;


public interface EmpOutletService {
	public List<EmpOutletModel> getList();
	public EmpOutletModel getById(Integer id);
	public void insert(EmpOutletModel item);
}