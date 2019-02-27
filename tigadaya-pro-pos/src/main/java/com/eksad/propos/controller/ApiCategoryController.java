package com.eksad.propos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.CategoryModel;
import com.eksad.propos.service.CategoryService;

@Controller
public class ApiCategoryController {

		@Autowired
		private CategoryService catService;

		@RequestMapping(value = "/api/category/", method = RequestMethod.GET)
		public ResponseEntity<List<CategoryModel>> list() {
			ResponseEntity<List<CategoryModel>> result = null;
			try {
				List<CategoryModel> list = this.catService.getList();
				result = new ResponseEntity<List<CategoryModel>>(list, HttpStatus.OK);
			} catch (Exception e) {
				result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return result;
			
		}
		
		//coba aja
}
