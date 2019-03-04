package com.eksad.propos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.PoDetailModel;
import com.eksad.propos.model.PurchaseOrderModel;
import com.eksad.propos.model.SupplierModel;
import com.eksad.propos.service.InvenService;
import com.eksad.propos.service.PoDetailService;
import com.eksad.propos.service.PurchaseOrderService;
import com.eksad.propos.service.SupplierService;

@Controller
public class PurchaseOrderController extends BaseController {
	
	@Autowired
	private PurchaseOrderService service;
	
	@Autowired
	private PoDetailService service2;
	
	@Autowired
	private SupplierService service3;

	@RequestMapping(value = "/po")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "purchase_order/index";
	}
	
	@RequestMapping(value = "/po/edit")
	public String edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		// load data => memanggil data, lewat method getById, param id
		PurchaseOrderModel pom = this.service.getById(id);
		
		List<SupplierModel> items = new ArrayList<SupplierModel>();
		items = this.service3.getList();
		
		// mengirim data dari controller ke view
		model.addAttribute("pom", pom);
		model.addAttribute("supl", items);
		
		return "purchase_order/edit";
	}
	
	@RequestMapping(value = "/po/view", method=RequestMethod.GET)
	public String view(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		// load data => memanggil data, lewat method getById, param id
		List<PoDetailModel> podm = this.service2.getByPoId(id);
		// mengirim data dari controller ke view
		model.addAttribute("pod", podm);
		
		return "purchase_order/view";
	}
}
