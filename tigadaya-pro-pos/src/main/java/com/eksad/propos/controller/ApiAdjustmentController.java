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

import com.eksad.propos.model.AdjustmentModel;
import com.eksad.propos.service.AdjustmentService;

@Controller
public class ApiAdjustmentController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private AdjustmentService service;
	
	@RequestMapping(value="/api/adjustment/", method=RequestMethod.GET)
	public ResponseEntity<List<AdjustmentModel>> list(){
		log.debug("test");
		ResponseEntity<List<AdjustmentModel>> result = null;
		try {
			List<AdjustmentModel> list = this.service.getList();
			result = new ResponseEntity<List<AdjustmentModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/adjustment/search/{katakunci}", method=RequestMethod.GET)
	public ResponseEntity<List<AdjustmentModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<AdjustmentModel>> result = null;
		//karna null maka harus d instansiasi
		try {
			List<AdjustmentModel> list = this.service.search(cari);
			result = new ResponseEntity<List<AdjustmentModel>>(list, HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
			
		return result;
	}
	
	//membaca ID
	@RequestMapping(value="/api/adjustment/{catId}")
	public ResponseEntity<AdjustmentModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<AdjustmentModel> result = null;
		try {
			AdjustmentModel cat = this.service.getById(vId);
			result = new ResponseEntity<AdjustmentModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	//post untuk http request method
	@RequestMapping(value="/api/adjustment/", method=RequestMethod.POST)
	public ResponseEntity<AdjustmentModel> postInsert(@RequestBody AdjustmentModel item){
		ResponseEntity<AdjustmentModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<AdjustmentModel>(item, HttpStatus. CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<AdjustmentModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	//ganti
	@RequestMapping(value="/api/adjustment/", method=RequestMethod.PUT)
	public ResponseEntity<AdjustmentModel> putUpdate(@RequestBody AdjustmentModel item){
		ResponseEntity<AdjustmentModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<AdjustmentModel>(item, HttpStatus. ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<AdjustmentModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	//apus
	@RequestMapping(value="/api/adjustment/{catId}", method=RequestMethod.DELETE)
	public ResponseEntity<AdjustmentModel> delApi(@PathVariable("catId") Integer vid){
		ResponseEntity<AdjustmentModel> result = null;
		try {
			AdjustmentModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<AdjustmentModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<AdjustmentModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<AdjustmentModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}