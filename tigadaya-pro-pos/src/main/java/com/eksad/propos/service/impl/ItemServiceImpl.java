package com.eksad.propos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.eksad.propos.dao.InvenDao;
import com.eksad.propos.dao.ItemDao;
import com.eksad.propos.dao.VariantDao;
import com.eksad.propos.model.InvenModel;
import com.eksad.propos.model.ItemForm;
import com.eksad.propos.model.ItemModel;
import com.eksad.propos.model.VariantModel;
import com.eksad.propos.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;

	@Autowired
	private VariantDao daoad;

	@Autowired
	private InvenDao daoin;

	@Override
	public List<ItemModel> getList() {
		return this.dao.getList();
	}

	@Override
	public void insert(ItemForm model) {
		ItemModel io = model.getIo();
		io.setActive(true);
		this.dao.insert(io);

		if (model.getVm() != null) {
			for (VariantModel detail : model.getVm()) {
				detail.setId(io.getId());
				detail.setActive(true);
				detail.setModifiedBy(1);
				this.daoad.insert(detail);
			}
		}

		if (model.getIm() != null) {
			for (InvenModel inven : model.getIm()) {
				inven.setId(io.getId());
				inven.setVariantId(1);
				inven.setOutletId(1);
				inven.setPurchaseQty(1);
				inven.setSalesOrderQty(1);
				inven.setTransferStockQty(1);
				inven.setAdjustmentQty(1);
				inven.setEndingQty(1);
				this.daoin.insert(inven);
			}
		}
	}

	@Override
	public List<ItemModel> search(String key) {
		return this.dao.search(key);
	}

	@Override
	public void update(ItemModel model) {
		this.dao.update(model);
		
	}

	@Override
	public ItemModel getById(Integer id) {
		return this.dao.getById(id);
	}

	}

