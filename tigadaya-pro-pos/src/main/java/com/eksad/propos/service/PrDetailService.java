package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.PrDetailModel;

public interface PrDetailService {
	public List<PrDetailModel> getList();
	public List<PrDetailModel> getByPrId (Integer id);
	public List<PrDetailModel> getByVarId (Integer varId);
}
