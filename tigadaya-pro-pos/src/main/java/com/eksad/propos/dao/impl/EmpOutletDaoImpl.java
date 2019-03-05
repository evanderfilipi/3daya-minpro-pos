package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.EmpOutletDao;
import com.eksad.propos.dao.UserDao;
import com.eksad.propos.model.EmpOutletModel;


@Repository
public class EmpOutletDaoImpl implements EmpOutletDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmpOutletModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from EmpOutletModel ep";
		Query query = session.createQuery(hql);
		List<EmpOutletModel> result = query.getResultList();
		return result;
	}

	@Override
	public EmpOutletModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from EmpOutletModel ep where ep.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		EmpOutletModel result = (EmpOutletModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(EmpOutletModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}
	
	



}