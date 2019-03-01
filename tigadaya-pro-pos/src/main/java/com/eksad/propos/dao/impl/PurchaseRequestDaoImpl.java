package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.PurchaseRequestDao;
import com.eksad.propos.model.PurchaseRequestModel;

@Repository
public class PurchaseRequestDaoImpl implements PurchaseRequestDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PurchaseRequestModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select pr from PurchaseRequestModel pr";
		Query query = session.createQuery(hql);
		List<PurchaseRequestModel> result = query.getResultList();
		return result;
	}

	@Override
	public PurchaseRequestModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select pr from PurchaseRequestModel pr where ep.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PurchaseRequestModel result = (PurchaseRequestModel) query.getSingleResult();
		return result;
	}
	
	public void insert(PurchaseRequestModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public String getNewCode() {
		Session session = sessionFactory.getCurrentSession();
		String hql="select cd from PurchaseRequestModel cd where cd.prNo=(select max(prNo) from PurchaseRequestModel)";
		Query query = session.createQuery(hql);
		String kodeBaru = "";
		if(query.getResultList().size()>0) {
			PurchaseRequestModel jt = (PurchaseRequestModel) query.getSingleResult();
			kodeBaru=jt.getPrNo();
			int mCode = Integer.parseInt(kodeBaru.substring(1,5));
			mCode++;
			kodeBaru="PR" + String.format("%04d", mCode);
		} else {
			kodeBaru="PR001";
		}
		
		return kodeBaru;
		
	}
}