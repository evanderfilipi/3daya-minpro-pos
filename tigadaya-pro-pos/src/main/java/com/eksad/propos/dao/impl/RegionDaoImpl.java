package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.RegionDao;
import com.eksad.propos.model.RegionModel;

@Repository
public class RegionDaoImpl implements RegionDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<RegionModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select rm from RegionModel rm";
		Query query = session.createQuery(hql);
		List<RegionModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<RegionModel> getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select rm from RegionModel rm where rm.provinceId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<RegionModel> result = query.getResultList();
		return result;
	}
}
