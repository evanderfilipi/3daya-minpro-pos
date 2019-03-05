package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.PoDetailModel;

public interface PoDetailDao {

	public List<PoDetailModel> getList();
	public List<PoDetailModel> getByPoId (Integer id);
	public List<PoDetailModel> getByVarId (Integer varId);
}
