package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.view.CustomerExcelView;
import com.app.view.CustomerPdfView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "CustomerRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertOrder(@ModelAttribute Customer customer, ModelMap map) {
		map.addAttribute("message", "Order Saved with id '" + service.saveCustomer(customer) + "' Sucessfully");
		map.addAttribute("customer", new Customer());
		return "CustomerRegister";
	}

	@RequestMapping("/all")
	public String showAllOrder(ModelMap map) {
		map.addAttribute("customers", service.getAllCustomers());
		return "CustomerDatas";
	}

	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteCuctomer(id);
		map.addAttribute("message", "Customer ID '" + id + "' Deleted Sucessfully");
		map.addAttribute("customers", service.getAllCustomers());
		return "CustomerDatas";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("customer", service.getOneCustomerById(id));
		return "CustomerUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute Customer customer, ModelMap map) {
		service.updateCustomer(customer);
		map.addAttribute("message", "Order Id  '" + customer.getCustId() + "'  Updated Sucessfully");
		map.addAttribute("customers", service.getAllCustomers());
		return "CustomerDatas";
	}
	
	@RequestMapping("/excel")
	public ModelAndView getExcelView() {
		return new ModelAndView(new CustomerExcelView(), new ModelMap().addAttribute("customers", service.getAllCustomers()));
	}
	
	@RequestMapping("/pdf")
	public ModelAndView getPDFView() {
		return new ModelAndView(new CustomerPdfView(), new ModelMap().addAttribute("customers", service.getAllCustomers()));
	}
}
