package com.eksad.propos.service;


import java.util.List;
import com.eksad.propos.model.InvenModel;

public interface InvenService {
	public List<InvenModel> getList();
	public void insert(InvenModel model);
	public InvenModel getById(Integer id);
}
