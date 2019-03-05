package com.eksad.propos.service;


import java.util.List;
import com.eksad.propos.model.VariantModel;

public interface VariantService {
	public List<VariantModel> getList();
	public void insert(VariantModel model);
	public VariantModel getByItemId(Integer id);
	public String getNewSku();
}
