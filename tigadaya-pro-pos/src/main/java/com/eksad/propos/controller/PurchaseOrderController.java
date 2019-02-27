package com.eksad.propos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseOrderController {

	@RequestMapping(value = "/po")
	public String index() {
		return "purchase_order/index";
	}
	
	@RequestMapping(value = "/po/edit/")
	public String edit() {
		return "purchase_order/edit";
	}
	
	@RequestMapping(value = "/po/view/")
	public String view() {
		return "purchase_order/view";
	}
}
