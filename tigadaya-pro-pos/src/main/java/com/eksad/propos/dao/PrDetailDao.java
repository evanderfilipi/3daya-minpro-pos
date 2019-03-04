package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.PrDetailModel;

public interface PrDetailDao {
	public List<PrDetailModel> getList();
	public List<PrDetailModel> getByPrId (Integer id);
	public List<PrDetailModel> getByVarId (Integer varId);
}
