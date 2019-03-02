package com.eksad.propos.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.EmployeeModel;
import com.eksad.propos.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value = "/employee",method=RequestMethod.GET)
	public String index(Model model) {
		List<EmployeeModel> items= new ArrayList<EmployeeModel>();
		items = this.service.getList();
		model.addAttribute("dataList", items);
		return "employee/index";
	}


	@RequestMapping(value = "/employee/create")
	public String create() {
		return "employee/create";
	}

	@RequestMapping(value = "/employee/edit")
	public String edit() {
		return "employee/edit";
	}
	@RequestMapping(value = "/employee/delete")
	public String delete() {
		return "employee/delete";
	}
	@RequestMapping(value = "/employee/assignOutlet")
	public String assign() {
		return "employee/assignOutlet";
	}
	
}
