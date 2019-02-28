package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.AdjustmentInputModel;

public interface AdjustmentInputDao {
	public List<AdjustmentInputModel> getList();
	public AdjustmentInputModel getById(Integer id);
	public AdjustmentInputModel getByAdid(Integer adId);
	public void insert(AdjustmentInputModel model);
	public void update(AdjustmentInputModel model);
	public void delete(AdjustmentInputModel model);
}