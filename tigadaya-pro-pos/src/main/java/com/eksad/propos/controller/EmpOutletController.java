package com.eksad.propos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.EmpOutletService;

@Controller
public class EmpOutletController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private EmpOutletService service;
	
	@RequestMapping(value = "/empOutlet")
	public String index(Model model) {
		return "empOutlet/index";
	}
	
	@RequestMapping(value = "/empOutlet/create")
	public String create() {
		return "empOutlet/create";
	}
	
	@RequestMapping(value = "/empOutlet/edit")
	public String edit() {
		return "empOutlet/edit";
	}
	
	
}
