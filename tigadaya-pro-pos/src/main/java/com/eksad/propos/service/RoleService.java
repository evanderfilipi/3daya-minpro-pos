package com.eksad.propos.service;

import java.util.List;

import com.eksad.propos.model.RoleModel;

public interface RoleService {
	public List<RoleModel> getList();
	public void insert(RoleModel model);
}
