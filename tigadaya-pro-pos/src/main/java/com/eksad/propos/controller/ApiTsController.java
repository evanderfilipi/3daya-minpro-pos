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

import com.eksad.propos.model.OutletModel;
import com.eksad.propos.model.TsModel;
import com.eksad.propos.service.TsService;

@Controller
public class ApiTsController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private TsService service;
	
	@RequestMapping(value="/api/ts/", method = RequestMethod.GET)
	public ResponseEntity<List<TsModel>> tsList(){
			ResponseEntity<List<TsModel>> result = null;
			try {
				List<TsModel> list = this.service.getList();
				result = new ResponseEntity<List<TsModel>>(list, HttpStatus.OK);
			} catch (Exception e) {
				//log.debug(e.getMessage(),e);
				result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}		
			return result;
	}
	
	@RequestMapping(value="/api/ts/search/{katakunci}", method=RequestMethod.GET)
	public ResponseEntity<List<TsModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<TsModel>> result = null;
		try {
			List<TsModel> tsList = this.service.search(cari);
			result = new ResponseEntity<List<TsModel>>(tsList,HttpStatus.OK);
		} catch (Exception e) {
			//log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;		
	}
	
	@RequestMapping(value="/api/ts/{tsId}",method=RequestMethod.GET)
	public ResponseEntity<List<TsModel>> getById(@PathVariable("tsId") int tstockId){
		ResponseEntity<List<TsModel>> result = null;
		try {
			List<TsModel> tsm = this.service.getById(tstockId);
			result = new ResponseEntity<List<TsModel>>(tsm,HttpStatus.OK);
		} catch (Exception e) {
			//log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/ts/", method=RequestMethod.POST)
	public ResponseEntity<TsModel> postInsert(@RequestBody TsModel item){
		ResponseEntity<TsModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<TsModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<TsModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
