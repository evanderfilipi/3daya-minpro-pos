package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.PoDetailDao;
import com.eksad.propos.model.PoDetailModel;

@Repository
public class PoDetailDaoImpl implements PoDetailDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PoDetailModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select podm from PoDetailModel podm";
		Query query = session.createQuery(hql);
		List<PoDetailModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<PoDetailModel> getByPoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select podm from PoDetailModel podm where podm.poId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<PoDetailModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<PoDetailModel> getByVarId(Integer varId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select im.beginning from PoDetailModel podm inner join InvenModel im on podm.variantId=im.variantId where podm.poId=:varId";
		Query query = session.createQuery(hql);
		query.setParameter("varId", varId);
		List<PoDetailModel> result = query.getResultList();
		return result;
	}

}
