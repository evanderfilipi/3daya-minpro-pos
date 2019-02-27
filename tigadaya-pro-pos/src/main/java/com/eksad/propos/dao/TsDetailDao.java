package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.TsDetailModel;

public interface TsDetailDao {
	public List<TsDetailModel> getList();
	public TsDetailModel getById(Integer id);
	public TsDetailModel getByTsId(Integer poId);
	public void insert(TsDetailModel model);
}
