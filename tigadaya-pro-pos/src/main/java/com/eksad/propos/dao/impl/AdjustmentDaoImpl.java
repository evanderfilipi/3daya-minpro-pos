package com.eksad.propos.dao.impl;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.AdjustmentDao;
import com.eksad.propos.model.AdjustmentModel;



@Repository
public class AdjustmentDaoImpl implements AdjustmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AdjustmentModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ad from AdjustmentModel ad";
		Query query = session.createQuery(hql);
		List<AdjustmentModel> result = query.getResultList();
		return result;
	}

	@Override
	public AdjustmentModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ad from AdjustmentModel ad where ad.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		AdjustmentModel result = (AdjustmentModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(AdjustmentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void update(AdjustmentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(AdjustmentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<AdjustmentModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		//name : properti yang ada di pecagesmodel
		String hql = "select x from AdjustmentModel x where x.name like :keySearch";
		//yang ada :sambung ":keySearch" adalah parameter
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

}