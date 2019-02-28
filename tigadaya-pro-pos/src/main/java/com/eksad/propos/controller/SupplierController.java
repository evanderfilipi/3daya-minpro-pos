package com.eksad.propos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.SupplierService;

@Controller
public class SupplierController extends BaseController{

	@Autowired
	private SupplierService service;
	
	@RequestMapping(value = "/supplier")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "supplier/index";
	}
	
	@RequestMapping(value="/supplier/create/")
	public String create() {
		return "supplier/create";
	}
	
	@RequestMapping(value="/supplier/edit/")
	public String edit() {
		return "supplier/edit";
	}
}
