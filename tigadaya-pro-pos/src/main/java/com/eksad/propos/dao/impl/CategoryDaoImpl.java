package com.eksad.propos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.CategoryDao;
import com.eksad.propos.model.CategoryModel;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<CategoryModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select cm from CategoryModel cm";
		org.hibernate.query.Query<CategoryModel> query = session.createQuery(hql);
		return query.getResultList();
	}

}