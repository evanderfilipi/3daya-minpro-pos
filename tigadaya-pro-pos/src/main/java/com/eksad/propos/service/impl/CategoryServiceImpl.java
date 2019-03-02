package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.CategoryDao;
import com.eksad.propos.model.CategoryModel;
import com.eksad.propos.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao dao;
	
	@Override
	public List<CategoryModel> getList() {
		return this.dao.getList();
	}

	@Override
	public CategoryModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(CategoryModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(CategoryModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(CategoryModel model) {
		this.dao.delete(model);
	}
	
	//bagian dari API
	@Override
	public List<CategoryModel> search(String key) {
		return this.dao.search(key);
	}
	
}