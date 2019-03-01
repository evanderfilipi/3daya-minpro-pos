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

import com.eksad.propos.model.PurchaseRequestModel;
import com.eksad.propos.model.PurchaseRequestModel;
import com.eksad.propos.service.PurchaseRequestService;




@Controller
public class ApiPurchaseRequestController {

	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PurchaseRequestService service;
	
	@RequestMapping(value="/api/purchaserequest/", method=RequestMethod.GET)
	public ResponseEntity<List<PurchaseRequestModel>> list(){
		ResponseEntity<List<PurchaseRequestModel>> result = null;
		try {
			List<PurchaseRequestModel> list = this.service.getList();
			result = new ResponseEntity<List<PurchaseRequestModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	} 
	
	
	@RequestMapping(value="/api/purchaserequest/{catId}")
	public ResponseEntity<PurchaseRequestModel> getById (@PathVariable("catId")int vId){
		ResponseEntity<PurchaseRequestModel> result=null;
		try {
			PurchaseRequestModel cat = this.service.getById(vId);
			result = new ResponseEntity<PurchaseRequestModel>(cat, HttpStatus.OK);
			
					
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping (value="api/purchaserequest/", method=RequestMethod.POST)
	public ResponseEntity<PurchaseRequestModel> postInsert(@RequestBody PurchaseRequestModel item){
		ResponseEntity<PurchaseRequestModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<PurchaseRequestModel>(item, HttpStatus.CREATED);
			
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PurchaseRequestModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result; 
	}
}
