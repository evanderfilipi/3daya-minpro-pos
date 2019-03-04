package com.eksad.propos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.AdjustmentService;

@Controller
public class AdjustmentController extends BaseController{
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private AdjustmentService service;
	
	@RequestMapping(value="/adjustment")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "adjustment/index";
	}
	
	@RequestMapping(value="adjustment/create")
	public String create() {
		return "adjustment/create";
	}
	
	@RequestMapping(value="/adjustment/form-adjustment")
	public String formProduct() {
		return "adjustment/formAdjustment";
	}
	
	@RequestMapping(value="adjustment/edit")
	public String edit() {
		return "adjustment/edit";
	}
	
	@RequestMapping(value="adjustment/delete")
	public String delete() {
		return "adjustment/delete";
	}
	
	@RequestMapping(value="adjustment/detail")
	public String detail() {
		return "adjustment/detail";
	}
}