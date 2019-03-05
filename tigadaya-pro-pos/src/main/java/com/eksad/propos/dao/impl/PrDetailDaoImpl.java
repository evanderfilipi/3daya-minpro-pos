package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.PrDetailDao;
import com.eksad.propos.model.PrDetailModel;

@Repository
public class PrDetailDaoImpl implements PrDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<PrDetailModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select prdm from PrDetailModel prdm";
		Query query = session.createQuery(hql);
		List<PrDetailModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<PrDetailModel> getByPrId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select prdm from PrDetailModel prdm where prdm.prId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<PrDetailModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<PrDetailModel> getByVarId(Integer varId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select im.beginning from PrDetailModel prdm inner join InvenModel im on prdm.variantId=im.variantId where prdm.prId=:varId";
		Query query = session.createQuery(hql);
		query.setParameter("varId", varId);
		List<PrDetailModel> result = query.getResultList();
		return result;
	}

}
