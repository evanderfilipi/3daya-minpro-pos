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
import com.eksad.propos.service.InvenService;
import com.eksad.propos.service.PoDetailService;
import com.eksad.propos.service.PurchaseOrderService;

@Controller
public class PurchaseOrderController extends BaseController {
	
	@Autowired
	private PurchaseOrderService service;
	
	@Autowired
	private PoDetailService service2;
	
	@Autowired
	private InvenService service3;

	@RequestMapping(value = "/po")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());
		return "purchase_order/index";
	}
	
	@RequestMapping(value = "/po/edit/")
	public String edit() {
		return "purchase_order/edit";
	}
	
	@RequestMapping(value = "/po/view", method=RequestMethod.GET)
	public String view(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		// load data => memanggil data, lewat method getById, param id
		List<PoDetailModel> podm = this.service2.getByPoId(id);
		// mengirim data dari controller ke view
		model.addAttribute("pod", podm);
		
		List<PoDetailModel> podm2 = this.service2.getByVarId(id);
		// mengirim data dari controller ke view
		model.addAttribute("pod2", podm2);
		return "purchase_order/view";
	}
}
