package com.eksad.propos.dao.impl;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.AdjustmentInputDao;
import com.eksad.propos.model.AdjustmentInputModel;


@Repository
public class AdjustmentInputDaoImpl implements AdjustmentInputDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdjustmentInputModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a form AdjustmentInputModel a";
		Query query = session.createQuery(hql);
		List<AdjustmentInputModel> result = query.getResultList();
		return null;
	}

	@Override
	public AdjustmentInputModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a from AdjustmentInputModel a where a.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		AdjustmentInputModel result = (AdjustmentInputModel)query.getSingleResult();
		return result;
	}

	@Override
	public AdjustmentInputModel getByAdid(Integer adId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select d from AdjustmentInputModel a where a.adId=:adId";
		Query query = session.createQuery(hql);
		query.setParameter("adId", adId);
		AdjustmentInputModel result = (AdjustmentInputModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(AdjustmentInputModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
		
	}

	@Override
	public void update(AdjustmentInputModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(AdjustmentInputModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}
}
