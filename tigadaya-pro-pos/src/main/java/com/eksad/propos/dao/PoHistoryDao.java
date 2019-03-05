package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.PoHistoryModel;

public interface PoHistoryDao {

	public List<PoHistoryModel>getByPoId(Integer poId);
	public void insert(PoHistoryModel model);
}
