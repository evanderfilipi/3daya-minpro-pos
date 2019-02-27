package com.eksad.propos.dao;
import java.util.List;
import com.eksad.propos.model.InvenModel;

public interface InvenDao {
	
	public List<InvenModel> getList();
	public void insert(InvenModel model);
	public InvenModel getById(Integer id);
}
