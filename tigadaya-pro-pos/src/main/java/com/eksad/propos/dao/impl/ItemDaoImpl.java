package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.eksad.propos.dao.ItemDao;
import com.eksad.propos.model.ItemModel;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ItemModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select ct from ItemModel ct";
		Query query = session.createQuery(hql);
		List<ItemModel> result = query.getResultList();
		return result;
	}

	
	@Override
	public void insert(ItemModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
		
	}


	public List<ItemModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select pk from ItemModel pk where pk.name like :keySearch"; 
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");
		return query.getResultList();
	}


	@Override
	public void update(ItemModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
		
	}


	@Override
	public ItemModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ct from ItemModel ct where ct.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ItemModel result = (ItemModel) query.getSingleResult();
		return result;
	}}
