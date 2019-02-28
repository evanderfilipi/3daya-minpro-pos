package com.eksad.propos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.CategoryService;

@Controller
<<<<<<< HEAD
public class CategoryController {
	private Log log = LogFactory.getLog(getClass()); 
=======
public class CategoryController extends BaseController{

>>>>>>> 29b22fd6c7f81047b48c862bcd1b14994cb8ea19
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value="/category")
<<<<<<< HEAD
	public String index() {	
=======
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
>>>>>>> 29b22fd6c7f81047b48c862bcd1b14994cb8ea19
		return "category/index";
	}
	
	@RequestMapping(value="/category/create")
	public String create() {
		return "category/create";
	}
	
	@RequestMapping(value="/category/edit")
	public String edit() {
		return "category/edit";
	}
	
	@RequestMapping(value="/category/delete")
	public String delete() {
		return "category/delete";
	}
	@RequestMapping(value="/category/detail")
	public String detail() {		
		return "category/detail";
	}
	
}