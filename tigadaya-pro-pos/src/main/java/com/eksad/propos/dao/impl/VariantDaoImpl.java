package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eksad.propos.dao.VariantDao;
import com.eksad.propos.model.VariantModel;

@Repository
public class VariantDaoImpl implements VariantDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(VariantModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
		
	}

	@Override
	public List<VariantModel> getList() {
		return null;
	}

	@Override
	public VariantModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ct from VariantModel ct where ct.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		VariantModel result = (VariantModel) query.getSingleResult();
		return result;
	}}

	
	

