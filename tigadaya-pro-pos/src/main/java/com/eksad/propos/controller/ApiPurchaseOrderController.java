package com.eksad.propos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.PurchaseOrderModel;
import com.eksad.propos.service.PurchaseOrderService;

@Controller
public class ApiPurchaseOrderController {

	@Autowired
	private PurchaseOrderService poService;
	
	@RequestMapping(value = "/api/po/", method = RequestMethod.GET)
	public ResponseEntity<List<PurchaseOrderModel>> apiPurchaseOrderList() {
		ResponseEntity<List<PurchaseOrderModel>> result = null;
		try {
			List<PurchaseOrderModel> list = this.poService.getList();
			result = new ResponseEntity<List<PurchaseOrderModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/po/search/{tglA}/{tglB}/{status}/{poNo}", method = RequestMethod.GET)
	public ResponseEntity<List<PurchaseOrderModel>> search(@PathVariable("tglA") String tglA, @PathVariable("tglB") String tglB, @PathVariable("status") String status, @PathVariable("poNo") String poNo) {
		ResponseEntity<List<PurchaseOrderModel>> result = null;
		try {
			List<PurchaseOrderModel> list = this.poService.search(tglA, tglB, status, poNo);
			result = new ResponseEntity<List<PurchaseOrderModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// return type harus sama dengan jenis methodnya
		return result;
	}
	
	@RequestMapping(value = "/api/po/{poId}", method = RequestMethod.GET)
	public ResponseEntity<PurchaseOrderModel> getById(@PathVariable("poId") int po_Id) {
		ResponseEntity<PurchaseOrderModel> result = null;
		try {
			PurchaseOrderModel cat = this.poService.getById(po_Id);
			result = new ResponseEntity<PurchaseOrderModel>(cat, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/po/", method = RequestMethod.PUT)
	public ResponseEntity<PurchaseOrderModel> putUpdate(@RequestBody PurchaseOrderModel item) {
		ResponseEntity<PurchaseOrderModel> result = null;
		try {
			this.poService.editPo(item);
			result = new ResponseEntity<PurchaseOrderModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
