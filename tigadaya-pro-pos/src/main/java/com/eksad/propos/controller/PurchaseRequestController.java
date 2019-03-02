package com.eksad.propos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.PurchaseRequestService;

@Controller
public class PurchaseRequestController extends BaseController{
	
	@Autowired
	private PurchaseRequestService kd;
	
	@RequestMapping(value = "/purchaseRequest")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "purchaserequest/index";
	}
	
	@RequestMapping(value = "/purchaseRequest/create")
	public String create(Model model) {
		String code = this.kd.getNewCode();
		model.addAttribute("KodeBaru", code);
		return "purchaserequest/create";
	}
	
	@RequestMapping(value = "/purchaseRequest/addItem")
	public String additem() {
		return "purchaserequest/additem";
	}


}
