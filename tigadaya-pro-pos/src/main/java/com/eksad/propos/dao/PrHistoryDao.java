package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.PrHistoryModel;

public interface PrHistoryDao {
	public List<PrHistoryModel>getByPrId(Integer prId);
	public void insert(PrHistoryModel model);
}
