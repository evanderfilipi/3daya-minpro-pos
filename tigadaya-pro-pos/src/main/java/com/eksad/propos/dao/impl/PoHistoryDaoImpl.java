package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.PoHistoryDao;
import com.eksad.propos.model.PoHistoryModel;

@Repository
public class PoHistoryDaoImpl implements PoHistoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PoHistoryModel> getByPoId(Integer poId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select phm from PoHistoryModel phm where phm.poId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", poId);
		List<PoHistoryModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(PoHistoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

}
