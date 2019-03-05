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

import com.eksad.propos.model.PoDetailModel;
import com.eksad.propos.service.PoDetailService;

@Controller
public class ApiPoDetailController {
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PoDetailService service;
	
	@RequestMapping(value = "/api/podetail/id/{poId}", method = RequestMethod.GET)
	public ResponseEntity<List<PoDetailModel>> getById(@PathVariable("poId") int poId) {
		ResponseEntity<List<PoDetailModel>> result = null;
		try {
			List<PoDetailModel> pod = this.service.getByPoId(poId);
			result = new ResponseEntity<List<PoDetailModel>>(pod, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}
