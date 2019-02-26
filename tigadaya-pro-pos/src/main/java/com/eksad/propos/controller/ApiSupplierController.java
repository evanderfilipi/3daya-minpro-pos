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

import com.eksad.propos.service.SupplierService;
import com.eksad.propos.model.SupplierModel;

@Controller
public class ApiSupplierController {

	@Autowired
	private SupplierService supService;
	
	@RequestMapping(value = "/api/supplier/", method = RequestMethod.GET)
	public ResponseEntity<List<SupplierModel>> apiSupplierList() {
		ResponseEntity<List<SupplierModel>> result = null;
		try {
			List<SupplierModel> list = this.supService.getList();
			result = new ResponseEntity<List<SupplierModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/supplier/search/{katakunci}", method = RequestMethod.GET)
	public ResponseEntity<List<SupplierModel>> search(@PathVariable("katakunci") String cari) {
		ResponseEntity<List<SupplierModel>> result = null;
		try {
			List<SupplierModel> list = this.supService.search(cari);
			result = new ResponseEntity<List<SupplierModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// return type harus sama dengan jenis methodnya
		return result;
	}
	
	@RequestMapping(value = "/api/supplier/", method = RequestMethod.POST)
	public ResponseEntity<SupplierModel> postInsert(@RequestBody SupplierModel item) {
		ResponseEntity<SupplierModel> result = null;
		try {
			this.supService.insert(item);
			result = new ResponseEntity<SupplierModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/supplier/", method = RequestMethod.PUT)
	public ResponseEntity<SupplierModel> putUpdate(@RequestBody SupplierModel item) {
		ResponseEntity<SupplierModel> result = null;
		try {
			this.supService.update(item);
			result = new ResponseEntity<SupplierModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/supplier/{supId}", method = RequestMethod.GET)
	public ResponseEntity<SupplierModel> getById(@PathVariable("supId") int vId) {
		ResponseEntity<SupplierModel> result = null;
		try {
			SupplierModel cat = this.supService.getById(vId);
			result = new ResponseEntity<SupplierModel>(cat, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
