package com.eksad.propos.dao;
import java.util.List;

import com.eksad.propos.model.VariantModel;


public interface VariantDao {
	
	public List<VariantModel> getList();
	public void insert(VariantModel model);
<<<<<<< HEAD
	public VariantModel getByItemId(Integer id);
	public String getNewSku();
=======
	public VariantModel getById(Integer id);
	public List<VariantModel> getByVarId(Integer id);
>>>>>>> 2a108cb5d90c2aee81e4c02f152012596f4efe85
}
