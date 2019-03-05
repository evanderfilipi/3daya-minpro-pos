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

import com.eksad.propos.model.PoHistoryModel;
import com.eksad.propos.service.PoHistoryService;

@Controller
public class ApiPoHistoryController {

	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PoHistoryService service;
	
	@RequestMapping(value = "/api/pohistory/id/{poId}", method = RequestMethod.GET)
	public ResponseEntity<List<PoHistoryModel>> getById(@PathVariable("poId") int poId) {
		ResponseEntity<List<PoHistoryModel>> result = null;
		try {
			List<PoHistoryModel> cat = this.service.getByPoId(poId);
			result = new ResponseEntity<List<PoHistoryModel>>(cat, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/pohistory/", method = RequestMethod.POST)
	public ResponseEntity<PoHistoryModel> postInsert(@RequestBody PoHistoryModel item) {
		ResponseEntity<PoHistoryModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<PoHistoryModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
