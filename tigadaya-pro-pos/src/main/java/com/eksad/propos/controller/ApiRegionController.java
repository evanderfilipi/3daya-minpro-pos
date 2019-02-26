package com.eksad.propos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.RegionModel;
import com.eksad.propos.service.RegionService;



@Controller
public class ApiRegionController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private RegionService service;
	
	@RequestMapping(value="/api/region/", method = RequestMethod.GET)
	public ResponseEntity<List<RegionModel>> list(){
		ResponseEntity<List<RegionModel>> result = null;
		try {
			List<RegionModel> list = this.service.getList();
			result = new ResponseEntity<List<RegionModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/region/id/{catId}", method = RequestMethod.GET)
	public ResponseEntity<List<RegionModel>> getById(@PathVariable("catId") int vId) {
		ResponseEntity<List<RegionModel>> result = null;
		try {
			List<RegionModel> cat = this.service.getById(vId);
			result = new ResponseEntity<List<RegionModel>>(cat, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
