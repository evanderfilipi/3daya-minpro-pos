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

import com.eksad.propos.model.PrHistoryModel;
import com.eksad.propos.service.PrHistoryService;

@Controller
public class ApiPrHistoryController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PrHistoryService service;
	
	@RequestMapping(value = "/api/prhistory/id/{prId}", method = RequestMethod.GET)
	public ResponseEntity<List<PrHistoryModel>> getById(@PathVariable("prId") int prId) {
		ResponseEntity<List<PrHistoryModel>> result = null;
		try {
			List<PrHistoryModel> cat = this.service.getByPrId(prId);
			result = new ResponseEntity<List<PrHistoryModel>>(cat, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/prhistory/", method = RequestMethod.POST)
	public ResponseEntity<PrHistoryModel> postInsert(@RequestBody PrHistoryModel item) {
		ResponseEntity<PrHistoryModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<PrHistoryModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
