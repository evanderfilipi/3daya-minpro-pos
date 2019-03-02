package com.eksad.propos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.CategoryService;

@Controller
public class CategoryController extends BaseController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private CategoryService service;

	@RequestMapping(value = "/category")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());

		return "category/index";
	}

	@RequestMapping(value = "/category/create")
	public String create() {
		return "category/create";
	}

	@RequestMapping(value = "/category/edit")
	public String edit() {
		return "category/edit";
	}

	@RequestMapping(value = "/category/delete")
	public String delete() {
		return "category/delete";
	}

	@RequestMapping(value = "/category/detail")
	public String detail() {
		return "category/detail";
	}
}
