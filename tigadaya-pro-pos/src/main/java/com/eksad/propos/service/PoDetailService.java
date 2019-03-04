package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.PoDetailModel;

public interface PoDetailService {
	
	public List<PoDetailModel> getList();
	public List<PoDetailModel> getByPoId (Integer id);
	public List<PoDetailModel> getByVarId (Integer varId);
}
