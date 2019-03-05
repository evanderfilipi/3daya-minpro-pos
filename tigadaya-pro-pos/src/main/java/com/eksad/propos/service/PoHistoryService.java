package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.PoHistoryModel;

public interface PoHistoryService {
	public List<PoHistoryModel>getByPoId(Integer poId);
	public void insert(PoHistoryModel model);
}
