package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.OutletDao;
import com.eksad.propos.model.OutletModel;

@Repository
public class OutletDaoImpl implements OutletDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OutletModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select om from OutletModel om"; //order by om.code
		Query query = session.createQuery(hql);
		List<OutletModel> result = query.getResultList();
		return result;
	}

}
