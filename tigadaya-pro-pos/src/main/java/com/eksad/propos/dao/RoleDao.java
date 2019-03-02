package com.eksad.propos.dao;

import java.util.List;

import com.eksad.propos.model.RoleModel;

public interface RoleDao {
	public List<RoleModel> getList();
	public void insert(RoleModel model);
}
