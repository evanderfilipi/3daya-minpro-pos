package com.eksad.propos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;
		
	@RequestMapping(value="/category")
	public String index() {
		return "category/index";
	}
}
