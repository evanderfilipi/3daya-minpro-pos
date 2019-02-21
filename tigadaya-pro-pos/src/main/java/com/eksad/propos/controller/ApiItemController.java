package com.eksad.propos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.eksad.propos.model.ItemModel;
import com.eksad.propos.service.ItemService;

@Controller
public class ApiItemController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private ItemService service;
	
	//tambah di dao, dao impl, service, service impl
	@RequestMapping(value="/api/item", method=RequestMethod.GET)
	public ResponseEntity<List<ItemModel>> list(){
		log.debug("test");
		//methoth list, retunt type responEntity,typedata refrest karna dibuat di dalam class
		ResponseEntity<List<ItemModel>> result = null;
		//try : mencoba
		try {
			List<ItemModel> list = this.service.getList();
			result = new ResponseEntity<List<ItemModel>>(list, HttpStatus.OK);
		//catch : menangkap
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/item/", method=RequestMethod.POST)
	public ResponseEntity<ItemModel> postInsert(@RequestBody ItemModel item){
		ResponseEntity<ItemModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<ItemModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<ItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	}