package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.DistrictDao;
import com.eksad.propos.model.DistrictModel;

@Repository
public class DistrictDaoImpl implements DistrictDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DistrictModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select dm from DistrictModel dm";
		Query query = session.createQuery(hql);
		List<DistrictModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<DistrictModel> getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select dm from DistrictModel dm where dm.regionId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<DistrictModel> result = query.getResultList();
		return result;
	}

}
