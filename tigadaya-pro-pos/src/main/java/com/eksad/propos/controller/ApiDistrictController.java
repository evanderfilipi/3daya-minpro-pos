package com.eksad.propos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.DistrictModel;
import com.eksad.propos.model.SupplierModel;
import com.eksad.propos.service.DistrictService;

@Controller
public class ApiDistrictController {
	
	@Autowired
	private DistrictService disService;
	
	@RequestMapping(value = "/api/district/", method = RequestMethod.GET)
	public ResponseEntity<List<DistrictModel>> districtList() {
		ResponseEntity<List<DistrictModel>> result = null;
		try {
			List<DistrictModel> list = this.disService.getList();
			result = new ResponseEntity<List<DistrictModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/district/id/{catId}", method = RequestMethod.GET)
	public ResponseEntity<List<DistrictModel>> getById(@PathVariable("catId") int vId) {
		ResponseEntity<List<DistrictModel>> result = null;
		try {
			List<DistrictModel> cat = this.disService.getById(vId);
			result = new ResponseEntity<List<DistrictModel>>(cat, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}
