package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eksad.propos.dao.InvenDao;
import com.eksad.propos.model.InvenModel;


@Repository
public class InvenDaoImpl implements InvenDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(InvenModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
		
	}

	@Override
	public List<InvenModel> getList() {
		return null;
	}

	@Override
	public InvenModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ct from InvenModel ct where ct.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		InvenModel result = (InvenModel) query.getSingleResult();
		return result;
	}}