package com.eksad.propos.dao;
import java.util.List;

import com.eksad.propos.model.VariantModel;


public interface VariantDao {
	
	public List<VariantModel> getList();
	public void insert(VariantModel model);
	public VariantModel getByItemId(Integer id);
	public String getNewSku();
	public VariantModel getById(Integer id);
	public List<VariantModel> getByVarId(Integer id);

}
