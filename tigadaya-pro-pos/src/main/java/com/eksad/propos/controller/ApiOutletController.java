package com.eksad.propos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.OutletModel;
import com.eksad.propos.service.OutletService;

@Controller
public class ApiOutletController {
	
	//private Log log = LogFactory.getLog(getClass());

	@Autowired
	private OutletService service;
	
	/**@RequestMapping(value="/outlet/index")
	public String index(Model model){
		List<OutletModel> list = this.service.getList();
		model.addAttribute("list",list);
		return "/outlet/index";
	}**/
	
	@RequestMapping(value="/api/outlet/", method = RequestMethod.GET)
	public ResponseEntity<List<OutletModel>> outletList(){
			ResponseEntity<List<OutletModel>> result = null;
			try {
				List<OutletModel> list = this.service.getList();
				result = new ResponseEntity<List<OutletModel>>(list, HttpStatus.OK);
			} catch (Exception e) {
				//log.debug(e.getMessage(),e);
				result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}		
			return result;
	}
	
	@RequestMapping(value="/api/outlet/search/{katakunci}", method=RequestMethod.GET)
	public ResponseEntity<List<OutletModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<OutletModel>> result = null;
		try {
			List<OutletModel> outletList = this.service.search(cari);
			result = new ResponseEntity<List<OutletModel>>(outletList,HttpStatus.OK);
		} catch (Exception e) {
			//log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;		
	}
	
	@RequestMapping(value="/api/outlet/{omId}",method=RequestMethod.GET)
	public ResponseEntity<OutletModel> getById(@PathVariable("omId") int outletId){
		ResponseEntity<OutletModel> result = null;
		try {
			OutletModel om = this.service.getById(outletId);
			result = new ResponseEntity<OutletModel>(om,HttpStatus.OK);
		} catch (Exception e) {
			//log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/outlet/", method=RequestMethod.POST)
	public ResponseEntity<OutletModel> postInsert(@RequestBody OutletModel item){
		ResponseEntity<OutletModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<OutletModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			//log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/outlet/", method=RequestMethod.PUT)
	public ResponseEntity<OutletModel> putUpdate(@RequestBody OutletModel item){
		ResponseEntity<OutletModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<OutletModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			//log.debug(e.getMessage(),e);
			result = new ResponseEntity<OutletModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
