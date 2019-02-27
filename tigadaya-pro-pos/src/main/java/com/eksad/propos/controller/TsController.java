package com.eksad.propos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TsController {
	
	@RequestMapping(value = "/ts")
	public String index() {
		return "ts/index";
	}
	
	@RequestMapping(value="/ts/create")
	public String create() {
		return "ts/create";
	}
	
	@RequestMapping(value="/ts/additem")
	public String purchaseForm() {
		return "ts/additem";
	}
}
