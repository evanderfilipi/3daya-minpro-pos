package com.eksad.propos.controller;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.VariantModel;
import com.eksad.propos.service.VariantService;

@Controller
public class ApiVariantController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private VariantService service;

	@RequestMapping(value="/api/variant", method=RequestMethod.GET)
	public ResponseEntity<List<VariantModel>> list(){
		log.debug("test");
		//methoth list, retunt type responEntity,typedata refrest karna dibuat di dalam class
		ResponseEntity<List<VariantModel>> result = null;
		//try : mencoba
		try {
			List<VariantModel> list = this.service.getList();
			result = new ResponseEntity<List<VariantModel>>(list, HttpStatus.OK);
		//catch : menangkap
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/variant", method=RequestMethod.POST)
	public ResponseEntity<VariantModel> postInsert(@RequestBody VariantModel item){
		ResponseEntity<VariantModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<VariantModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<VariantModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}	
	
	@RequestMapping(value="/api/variant/{catId}",method=RequestMethod.GET)
	public ResponseEntity<VariantModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<VariantModel> result = null;
		try {
			VariantModel cat = this.service.getById(vId);
			result = new ResponseEntity<VariantModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<VariantModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/variant/id/{varId}", method = RequestMethod.GET)
	public ResponseEntity<List<VariantModel>> getByVarId(@PathVariable("varId") int poId) {
		ResponseEntity<List<VariantModel>> result = null;
		try {
			List<VariantModel> vi = this.service.getByVarId(poId);
			result = new ResponseEntity<List<VariantModel>>(vi, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	
	
	
	}