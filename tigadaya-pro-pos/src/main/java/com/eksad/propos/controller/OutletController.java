package com.eksad.propos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.OutletService;

@Controller
public class OutletController extends BaseController{

	@RequestMapping(value="/outlet")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "outlet/index";
	}
	
	@RequestMapping(value="/outlet/create")
	public String create() {
		return "outlet/create";
	}
	
	@RequestMapping(value="/outlet/edit")
	public String edit() {
		return "outlet/edit";
	}
}
