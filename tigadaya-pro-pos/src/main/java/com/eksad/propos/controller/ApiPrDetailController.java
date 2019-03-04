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

import com.eksad.propos.model.PrDetailModel;
import com.eksad.propos.service.PrDetailService;

@Controller
public class ApiPrDetailController {
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PrDetailService service;
	
	@RequestMapping(value = "/api/prdetail/id/{prId}", method = RequestMethod.GET)
	public ResponseEntity<List<PrDetailModel>> getById(@PathVariable("prId") int prId) {
		ResponseEntity<List<PrDetailModel>> result = null;
		try {
			List<PrDetailModel> prd = this.service.getByPrId(prId);
			result = new ResponseEntity<List<PrDetailModel>>(prd, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}
