package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.propos.dao.PurchaseOrderDao;
import com.eksad.propos.model.PurchaseOrderModel;
import com.eksad.propos.service.PurchaseOrderService;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderDao poDao;
	
	@Override
	public List<PurchaseOrderModel> getList() {
		return this.poDao.getList();
	}

	@Override
	public List<PurchaseOrderModel> search(String tglAwal, String tglAkhir, String status, String poNo) {
		return this.poDao.search(tglAwal, tglAkhir, status, poNo);
	}

	@Override
	public PurchaseOrderModel getById(Integer id) {
		return this.poDao.getById(id);
	}

	@Override
	public void editPo(PurchaseOrderModel poModel) {
		this.poDao.editPo(poModel);
	}

}
