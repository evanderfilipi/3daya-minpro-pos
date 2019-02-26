package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.TsDao;
import com.eksad.propos.model.TsModel;

@Repository
public class TsDaoImplement implements TsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TsModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ts from TsModel ts order by ts.id";
		Query query = session.createQuery(hql);
		List<TsModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<TsModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ts from TsModel ts where ts.toOutlet like :keySearch";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");
		List<TsModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<TsModel> getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ts from TsModel ts where ts.toOutlet=:id ";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TsModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(TsModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

}
