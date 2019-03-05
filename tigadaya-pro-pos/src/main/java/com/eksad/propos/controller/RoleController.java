package com.eksad.propos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.propos.service.RoleService;

public class RoleController {
	private Log log = LogFactory.getLog(getClass()); 
	@Autowired
	private RoleService service;
	
	@RequestMapping(value="/role/create")
	public String create() {
		return "role/create";
	}	
	
	@RequestMapping(value="role/detail")
	public String detail() {
		return "role/detail";
	}
}
