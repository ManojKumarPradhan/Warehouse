package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.view.VendorExcelVew;
import com.app.view.VendorPdfView;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private IVendorService service;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("vendor", new Vendor());
		return "VendorRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertData(@ModelAttribute Vendor vendor, ModelMap map) {
		map.addAttribute("message", "Vendor With id  '" + service.saveVendor(vendor) + "'  Inserted sucessfully");
		map.addAttribute("vendor", new Vendor());
		return "VendorRegister";
	}

	@RequestMapping("/all")
	public String showAllUom(ModelMap map) {
		map.addAttribute("vendors", service.getAllVendors());
		return "VendorDatas";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteVendor(id);
		map.addAttribute("message", "Vendor of ID '" + id + "' Deleted Sucessfully");
		map.addAttribute("vendors", service.getAllVendors());
		return "VendorDatas";
	}

	@RequestMapping("/edit")
	public String showUpdatePage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("vendor", service.getOneVendorById(id));
		return "VendorUpdate";
	}

	@RequestMapping("/update")
	public String updateUom(@ModelAttribute Vendor vendor, ModelMap map) {
		service.updateVendor(vendor);
		map.addAttribute("message", "Uom of ID '" + vendor.getId() + "' Updated Sucessfully");
		map.addAttribute("vendors", service.getAllVendors());
		return "VendorDatas";
	}

	@RequestMapping("/excel")
	public ModelAndView getExcelView() {
		return new ModelAndView(new VendorExcelVew(), new ModelMap().addAttribute("vendors", service.getAllVendors()));
	}

	@RequestMapping("/pdf")
	public ModelAndView getPDFView() {
		return new ModelAndView(new VendorPdfView(), new ModelMap().addAttribute("vendors", service.getAllVendors()));
	}
}