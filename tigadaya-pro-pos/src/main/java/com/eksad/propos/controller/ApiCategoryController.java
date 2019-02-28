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

import com.eksad.propos.model.CategoryModel;
import com.eksad.propos.service.CategoryService;

@Controller
public class ApiCategoryController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private CategoryService service;
	
	//tambah di dao, dao impl, service, service impl
	@RequestMapping(value="/api/category/", method=RequestMethod.GET)
	public ResponseEntity<List<CategoryModel>> list(){
		log.debug("test");
		//methoth list, retunt type  responEntity,typedata refrest karna dibuat di dalam class
		ResponseEntity<List<CategoryModel>> result = null;
		//try : mencoba
		try {
			List<CategoryModel> list = this.service.getList();
			result = new ResponseEntity<List<CategoryModel>>(list, HttpStatus.OK);
		//catch : menangkap
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	//tambah di dao, dao impl, service, service impl
	//API menggunakan {}
	//membaca {katakunci} lalu di tangkap pathvariable ("katakunci") dan di tampung ke variable cari
	@RequestMapping(value="/api/category/search/{katakunci}", method=RequestMethod.GET)
	public ResponseEntity<List<CategoryModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<CategoryModel>> result = null;
		//karna null maka harus d instansiasi
		try {
			List<CategoryModel> list = this.service.search(cari);
			result = new ResponseEntity<List<CategoryModel>>(list, HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
			
		return result;
	}
	
	//membaca ID
	@RequestMapping(value="/api/category/{catId}")
	public ResponseEntity<CategoryModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<CategoryModel> result = null;
		try {
			CategoryModel cat = this.service.getById(vId);
			result = new ResponseEntity<CategoryModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	//post untuk http request method
	@RequestMapping(value="/api/category/", method=RequestMethod.POST)
	public ResponseEntity<CategoryModel> postInsert(@RequestBody CategoryModel item){
		ResponseEntity<CategoryModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<CategoryModel>(item, HttpStatus. CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<CategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	//ganti
	@RequestMapping(value="/api/category/", method=RequestMethod.PUT)
	public ResponseEntity<CategoryModel> putUpdate(@RequestBody CategoryModel item){
		ResponseEntity<CategoryModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<CategoryModel>(item, HttpStatus. ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<CategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	//apus
	@RequestMapping(value="/api/category/{catId}", method=RequestMethod.DELETE)
	public ResponseEntity<CategoryModel> delApi(@PathVariable("catId") Integer vid){
		ResponseEntity<CategoryModel> result = null;
		try {
			CategoryModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<CategoryModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<CategoryModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<CategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
}