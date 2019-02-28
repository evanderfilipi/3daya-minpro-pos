package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.AdjustmentModel;

public interface AdjustmentDao {
	public List<AdjustmentModel> getList();
	public List<AdjustmentModel> search(String key);
	public AdjustmentModel getById(Integer id);
	public void insert(AdjustmentModel model);
	public void update(AdjustmentModel model);
	public void delete(AdjustmentModel model);

}