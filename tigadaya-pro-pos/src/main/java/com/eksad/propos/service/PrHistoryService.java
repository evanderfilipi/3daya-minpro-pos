package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.PrHistoryModel;

public interface PrHistoryService {
	public List<PrHistoryModel>getByPrId(Integer prId);
	public void insert(PrHistoryModel model);
}
