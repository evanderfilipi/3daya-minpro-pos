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

import com.eksad.propos.model.EmpOutletModel;
import com.eksad.propos.service.EmpOutletService;

@Controller
public class ApiEmpOutletController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private EmpOutletService service;
	
	@RequestMapping(value="/api/empOutlet/", method = RequestMethod.GET)
	public ResponseEntity<List<EmpOutletModel>> list(){
		ResponseEntity<List<EmpOutletModel>> result = null;
		try {
			List<EmpOutletModel> list = this.service.getList();
			result = new ResponseEntity<List<EmpOutletModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/empOutlet/{catId}", method = RequestMethod.GET)
	public ResponseEntity<EmpOutletModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<EmpOutletModel> result = null;
		try {
			EmpOutletModel cat = this.service.getById(vId);
			result = new ResponseEntity<EmpOutletModel>(cat, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	/*@RequestMapping(value="/api/empOutlet/search/{katakunci}", method = RequestMethod.GET)
	public ResponseEntity<List<EmpOutletModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<EmpOutletModel>> result = null;
		try {
			List<EmpOutletModel> list = this.service.search(cari);
			result = new ResponseEntity<List<EmpOutletModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}*/
	
	@RequestMapping(value="/api/empOutlet/",method = RequestMethod.POST)
	public ResponseEntity<EmpOutletModel> postInsert(@RequestBody EmpOutletModel item){
		ResponseEntity<EmpOutletModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<EmpOutletModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<EmpOutletModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	/*@RequestMapping(value="/api/empOutlet/", method = RequestMethod.PUT)
	public ResponseEntity<EmpOutletModel> putUpdate(@RequestBody EmpOutletModel item){
		ResponseEntity<EmpOutletModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<EmpOutletModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<EmpOutletModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}*/
}
