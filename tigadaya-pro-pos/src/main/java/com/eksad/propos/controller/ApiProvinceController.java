package com.eksad.propos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.ProvinceModel;
import com.eksad.propos.service.ProvinceService;

@Controller
public class ApiProvinceController {
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private ProvinceService service;

	@RequestMapping(value="/api/province/", method=RequestMethod.GET)
	public ResponseEntity<List<ProvinceModel>> list(){
		ResponseEntity<List<ProvinceModel>> result = null;
		try {
			List<ProvinceModel> list = this.service.getList();
			result = new ResponseEntity<List<ProvinceModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<ProvinceModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
}
