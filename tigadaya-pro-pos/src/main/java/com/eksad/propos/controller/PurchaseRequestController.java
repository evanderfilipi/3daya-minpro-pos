package com.eksad.propos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.propos.model.PrDetailModel;
import com.eksad.propos.service.InvenService;
import com.eksad.propos.service.PrDetailService;
import com.eksad.propos.service.PurchaseRequestService;

@Controller
public class PurchaseRequestController extends BaseController {

	@Autowired
	private PurchaseRequestService kd;
	
	@Autowired
	private PrDetailService service2;
	
	@Autowired
	private InvenService service3;
	
	@RequestMapping(value = "/pr")
	public String index(Model model) {
		model.addAttribute("username", this.getUserName());

		return "purchase_request/index";
	}
	
	@RequestMapping(value = "/pr/create")
	public String create(Model model) {
		String code = this.kd.getNewCode();
		model.addAttribute("KodeBaru", code);
		return "purchase_request/create";

	}
	
	@RequestMapping(value = "/pr/addItem")
	public String additem() {
		return "purchase_request/additem";
	}
	
	@RequestMapping(value = "/pr/view", method=RequestMethod.GET)
	public String view(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		// load data => memanggil data, lewat method getById, param id
		List<PrDetailModel> prdm = this.service2.getByPrId(id);
		// mengirim data dari controller ke view
		model.addAttribute("prd", prdm);
		
		List<PrDetailModel> prdm2 = this.service2.getByVarId(id);
		// mengirim data dari controller ke view
		model.addAttribute("prd2", prdm2);
		return "purchase_request/view";
	}

}
