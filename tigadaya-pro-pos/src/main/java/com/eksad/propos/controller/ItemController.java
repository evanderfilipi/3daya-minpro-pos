package com.eksad.propos.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController extends BaseController{

	@RequestMapping(value="/item")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "item/index";
	}
	
	@RequestMapping(value="/item/create")
	public String create() {
		return "item/create";
	}
	
	@RequestMapping(value="/item/variant")
	public String addVariant() {
		return "/item/variant";
	}
	
	@RequestMapping(value="/item/edit")
	public String edit() {
		return "item/edit";
	}
	
}
