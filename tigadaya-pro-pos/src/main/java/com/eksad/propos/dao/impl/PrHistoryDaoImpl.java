package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.PrHistoryDao;
import com.eksad.propos.model.PrHistoryModel;

@Repository
public class PrHistoryDaoImpl implements PrHistoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PrHistoryModel> getByPrId(Integer prId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select prm from PrHistoryModel prm where prm.prId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", prId);
		List<PrHistoryModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(PrHistoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

}
