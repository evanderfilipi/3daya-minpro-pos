package com.eksad.propos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eksad.propos.service.VariantService;
@Controller
public class ItemController extends BaseController {
	@Autowired
	private VariantService varservice;
	
	
	
	@RequestMapping(value="/item")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "item/index";
	}
	
	@RequestMapping(value="/item/create")
	public String create() {
		return "item/create";
	}
	
	@RequestMapping(value = "item/variant")
	public String addvar(Model model) {
		String code = this.varservice.getNewSku();
		model.addAttribute("kodeBaru", code);
		return "item/variant";
	}
	
	@RequestMapping(value="/item/edit")
	public String edit() {
		return "item/edit";
	}
	
}
