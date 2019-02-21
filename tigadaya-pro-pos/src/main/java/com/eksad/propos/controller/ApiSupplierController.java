package com.eksad.propos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
