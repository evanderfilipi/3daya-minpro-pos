package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.RoleDao;
import com.eksad.propos.model.RoleModel;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<RoleModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select rl from RoleModel rl";
		Query query = session.createQuery(hql);
		List<RoleModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(RoleModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}
		
	}
