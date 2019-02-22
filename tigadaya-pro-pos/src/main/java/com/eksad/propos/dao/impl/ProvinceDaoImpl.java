package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.ProvinceDao;
import com.eksad.propos.model.ProvinceModel;

@Repository
public class ProvinceDaoImpl implements ProvinceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProvinceModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select pm from ProvinceModel pm";
		Query query = session.createQuery(hql);
		List<ProvinceModel> result = query.getResultList();
		return result;
	}

}
