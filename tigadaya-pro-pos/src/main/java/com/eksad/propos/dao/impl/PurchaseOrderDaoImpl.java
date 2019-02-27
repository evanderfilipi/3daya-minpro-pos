package com.eksad.propos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.propos.dao.PurchaseOrderDao;
import com.eksad.propos.model.PurchaseOrderModel;

@Repository
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PurchaseOrderModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select pom from PurchaseOrderModel pom";
		Query query = session.createQuery(hql);
		List<PurchaseOrderModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<PurchaseOrderModel> search(String tglAwal, String tglAkhir, String status, String poNo) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select pom from PurchaseOrderModel pom where (pom.createdOn between '"+tglAwal+"' and '"+tglAkhir+"') "
				+ "and (pom.status='"+status+"') and (pom.poNo like '%"+poNo+"%')";
		Query query = session.createQuery(hql);
		List<PurchaseOrderModel> result = query.getResultList();
		return result;
	}

	@Override
	public PurchaseOrderModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select pom from PurchaseOrderModel pom where pom.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PurchaseOrderModel result = (PurchaseOrderModel) query.getSingleResult();
		return result;
	}

	@Override
	public void editPo(PurchaseOrderModel poModel) {
		Session session = sessionFactory.getCurrentSession();
		session.update(poModel);
	}

}
