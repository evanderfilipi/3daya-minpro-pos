package com.eksad.propos.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

	@RequestMapping(value="/item")
	public String index() {
		return "item/index";
	}
	
	@RequestMapping(value="/item/create")
	public String create() {
		return "item/create";
	}
	
}