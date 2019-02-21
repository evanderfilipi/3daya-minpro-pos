package com.eksad.propos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.OutletService;

@Controller
public class OutletController {
	
	@Autowired
	private OutletService service;

	@RequestMapping(value="/outlet")
	public String index() {
		return "outlet/index";
	}
}
