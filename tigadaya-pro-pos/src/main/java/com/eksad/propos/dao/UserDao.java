package com.eksad.propos.dao;

import java.util.List;
import com.eksad.propos.model.UserModel;

public interface UserDao {
	public List<UserModel> getList();
	public void insert(UserModel model);
	public void update(UserModel model);
	public void delete(UserModel model);
	public UserModel getById(Integer id);
}
