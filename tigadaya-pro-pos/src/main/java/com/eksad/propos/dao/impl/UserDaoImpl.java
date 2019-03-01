package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.UserDao;
import com.eksad.propos.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<UserModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select ur from UserModel ur";
		Query query = session.createQuery(hql);
		List<UserModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void update(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public UserModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select em from UserModel em where em.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		UserModel result = (UserModel)query.getSingleResult();
		return result;
	}

}
